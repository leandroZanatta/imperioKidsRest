package br.com.sysdesc.imperio.kids.repository.custom;

import java.util.List;

import br.com.sysdesc.imperio.kids.repository.projection.PrecoVendaProjection;
import br.com.sysdesc.imperio.kids.repository.projection.ProdutoLojaProjection;

public interface ProdutoRepositoryCustom {

	public abstract List<ProdutoLojaProjection> buscarProdutos(Long pagina, Long limit);

	public abstract PrecoVendaProjection buscarPrecoVenda(Long codigoProduto);

	public abstract Long contarProdutos();
}
