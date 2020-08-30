package br.com.sysdesc.imperio.kids.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.EstruturaProdutoDTO;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.service.EstruturaProdutoService;

@Service
public class EstruturaProdutoServiceImpl implements EstruturaProdutoService {

	@Override
	public List<EstruturaProdutoDTO> criarEstruturaProdutos(Categoria categoria) {

		List<EstruturaProdutoDTO> estrutura = new ArrayList<>();

		criarEstruturaProdutos(categoria, estrutura);

		Collections.reverse(estrutura);

		return estrutura;
	}

	private void criarEstruturaProdutos(Categoria categoria, List<EstruturaProdutoDTO> estrutura) {

		estrutura.add(new EstruturaProdutoDTO(categoria.getIdCategoria(), categoria.getDescricao()));

		if (categoria.getCategoria() != null) {

			criarEstruturaProdutos(categoria.getCategoria(), estrutura);
		}

	}
}
