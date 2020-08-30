package br.com.sysdesc.imperio.kids.service;

import java.util.List;

import br.com.sysdesc.imperio.kids.dto.EstruturaProdutoDTO;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;

public interface EstruturaProdutoService {

	public abstract List<EstruturaProdutoDTO> criarEstruturaProdutos(Categoria categoria);
}
