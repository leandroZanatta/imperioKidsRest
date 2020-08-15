package br.com.sysdesc.imperio.kids.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;
import br.com.sysdesc.imperio.kids.repository.CategoriasRepository;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.service.CategoriasService;
import br.com.sysdesc.imperio.kids.util.DateUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	@Lazy
	private CategoriasRepository categoriasRepository;

	@Override
	public Page<CategoriaDTO> listar(String valorPesquisa, Long pagina, Long registros) {

		if (!StringUtil.isNullOrEmpty(valorPesquisa)) {

			return map(categoriasRepository.findByDescricaoLikeIgnoreCase(String.format("%%%s%%", valorPesquisa),
					PageRequest.of(pagina.intValue(), registros.intValue())));
		}

		return map(categoriasRepository.findAll(PageRequest.of(pagina.intValue(), registros.intValue())));
	}

	private Page<CategoriaDTO> map(Page<Categoria> pagina) {

		return pagina.map(categoria -> {

			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setCodigoCategoria(categoria.getCodigoCategoria());
			categoriaDTO.setDescricao(categoria.getDescricao());
			categoriaDTO.setIdCategoria(categoria.getIdCategoria());

			if (categoria.getCategoria() != null) {

				categoriaDTO.setDescricaoPai(categoria.getCategoria().getDescricao());
			}

			if (categoria.getDataExclusao() != null) {

				categoriaDTO.setDataExclusao(DateUtil.formatString(categoria.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
			}

			return categoriaDTO;
		});
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

		categoriasRepository.save(categoria);
	}

	@Override
	public void excluir(Long codigoCategoria) {

		Categoria categoria = buscarCategoria(codigoCategoria);

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

}
