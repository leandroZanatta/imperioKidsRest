package br.com.sysdesc.imperio.kids.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;
import br.com.sysdesc.imperio.kids.dto.EstruturaCategoriaDTO;
import br.com.sysdesc.imperio.kids.repository.CategoriasRepository;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.service.CategoriasService;
import br.com.sysdesc.imperio.kids.service.EstruturaProdutoService;
import br.com.sysdesc.imperio.kids.util.DateUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	@Lazy
	private CategoriasRepository categoriasRepository;

	@Autowired
	@Lazy
	private EstruturaProdutoService estruturaProdutoService;

	@Override
	public Page<CategoriaDTO> listar(String valorPesquisa, Long pagina, Long registros, Boolean filtrarExcluidos) {

		List<CategoriaDTO> categorias = categoriasRepository.buscarCategorias(valorPesquisa, pagina, registros, filtrarExcluidos).stream()
				.map(this::map).collect(Collectors.toList());

		if (LongUtil.isNullOrZero(pagina)) {

			return new PageImpl<>(categorias, PageRequest.of(pagina.intValue(), registros.intValue()),
					categoriasRepository.contarCategorias(valorPesquisa, filtrarExcluidos));
		}

		return new PageImpl<>(categorias);
	}

	@Override
	public CategoriaDTO buscarPorId(Long codigoCategoria) {

		return map(buscarCategoria(codigoCategoria));
	}

	@Override
	public void salvar(CategoriaDTO categoriaDTO) {

		if (LongUtil.isNullOrZero(categoriaDTO.getIdCategoria())) {

			if (StringUtil.isNullOrEmpty(categoriaDTO.getDescricao())) {
				throw new SysDescException("O campo descrição não pode ser vazio");
			}

			if (LongUtil.isNullOrZero(categoriaDTO.getCodigoCategoria())) {

				if (categoriasRepository.existsByDescricao(categoriaDTO.getDescricao())) {
					throw new SysDescException("Categoria já está cadastrada, favor insira outra descrição");
				}
			} else {
				if (categoriasRepository.existsByDescricaoAndCodigoCategoria(categoriaDTO.getDescricao(), categoriaDTO.getCodigoCategoria())) {
					throw new SysDescException("Categoria já está cadastrada, favor insira outra descrição");
				}
			}
		}

		Categoria categoria = new Categoria();
		categoria.setDescricao(categoriaDTO.getDescricao());
		categoria.setCodigoCategoria(categoriaDTO.getCodigoCategoria());
		categoria.setIdCategoria(categoriaDTO.getIdCategoria());

		if (categoriaDTO.getDataExclusao() != null) {
			categoria.setDataExclusao(DateUtil.parseDate(categoriaDTO.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
		}

		categoriasRepository.save(categoria);
	}

	@Override
	public void excluir(Long codigoCategoria) {

		Categoria categoria = buscarCategoria(codigoCategoria);

		if (!categoria.getEstruturaMercadologicas().isEmpty()) {

			throw new SysDescException("Não é possivel excluir categoria com produtos vinculados.");
		}

		categoria.setDataExclusao(DateUtil.getDateTimeNow());

		categoriasRepository.save(categoria);
	}

	@Override
	public void reincluir(Long codigoCategoria) {
		Categoria categoria = buscarCategoria(codigoCategoria);

		categoria.setDataExclusao(null);

		categoriasRepository.save(categoria);
	}

	private Categoria buscarCategoria(Long codigoCategoria) {

		return categoriasRepository.findById(codigoCategoria)
				.orElseThrow(() -> new SysDescException("Categoria Não encontrada"));
	}

	@Override
	public List<EstruturaCategoriaDTO> obterEstrutura() {

		return montarEstrutura(categoriasRepository.findByDataExclusaoIsNullAndCodigoCategoriaIsNull());
	}

	private CategoriaDTO map(Categoria categoria) {

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setCodigoCategoria(categoria.getCodigoCategoria());
		categoriaDTO.setDescricao(categoria.getDescricao());
		categoriaDTO.setIdCategoria(categoria.getIdCategoria());
		categoriaDTO.setNumeroProdutos(Long.valueOf(categoria.getEstruturaMercadologicas().size()));

		if (categoria.getCategoria() != null) {

			categoriaDTO.setEstruturaMercadologica(estruturaProdutoService.criarEstruturaProdutos(categoria.getCategoria()));
		}

		if (categoria.getDataExclusao() != null) {

			categoriaDTO.setDataExclusao(DateUtil.formatString(categoria.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
		}

		return categoriaDTO;
	}

	private List<EstruturaCategoriaDTO> montarEstrutura(List<Categoria> categorias) {

		return categorias.stream().filter(categoria -> categoria.getDataExclusao() == null).map(categoria -> {
			EstruturaCategoriaDTO estruturaCategoriaDTO = new EstruturaCategoriaDTO();
			estruturaCategoriaDTO.setCodigoCategoria(categoria.getIdCategoria());
			estruturaCategoriaDTO.setDescricao(categoria.getDescricao());

			if (!categoria.getSubCategorias().isEmpty()) {
				estruturaCategoriaDTO.setSubcategorias(montarEstrutura(categoria.getSubCategorias()));
			}

			return estruturaCategoriaDTO;
		}).collect(Collectors.toList());
	}
}
