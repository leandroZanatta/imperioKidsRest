package br.com.sysdesc.imperio.kids.repository.custom;

import java.util.List;

import br.com.sysdesc.imperio.kids.repository.domain.Categoria;

public interface CategoriasRepositoryCustom {

	public abstract List<Categoria> buscarCategorias(String valorPesquisa, Long pagina, Long registros, Boolean filtrarExcluidos);

	public abstract Long contarCategorias(String valorPesquisa, Boolean filtrarExcluidos);

}
