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

}
