package br.com.sysdesc.imperio.kids.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.Categoria;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	public abstract boolean existsByDescricao(String descricao);

	public abstract boolean existsByDescricaoAndCodigoCategoria(String descricao, Long codigoCategoria);

	public abstract Page<Categoria> findByDescricaoLikeIgnoreCase(String valorPesquisa, Pageable page);

	public abstract List<Categoria> findByDataExclusaoIsNullAndCodigoCategoriaIsNull();

}
