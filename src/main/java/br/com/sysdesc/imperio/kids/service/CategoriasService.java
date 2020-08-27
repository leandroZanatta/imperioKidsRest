package br.com.sysdesc.imperio.kids.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;
import br.com.sysdesc.imperio.kids.dto.EstruturaCategoriaDTO;

public interface CategoriasService {

	public abstract Page<CategoriaDTO> listar(String valorPesquisa, Long pagina, Long registros);

	public abstract void salvar(CategoriaDTO categoriaDTO);

	public abstract void excluir(Long codigoCategoria);

	public abstract void reincluir(Long codigoCategoria);

	public abstract List<EstruturaCategoriaDTO> obterEstrutura();
}
