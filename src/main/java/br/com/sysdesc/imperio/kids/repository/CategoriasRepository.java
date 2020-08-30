package br.com.sysdesc.imperio.kids.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.custom.CategoriasRepositoryCustom;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;

@Repository
public interface CategoriasRepository extends CategoriasRepositoryCustom, JpaRepository<Categoria, Long> {

	public abstract boolean existsByDescricao(String descricao);

	public abstract boolean existsByDescricaoAndCodigoCategoria(String descricao, Long codigoCategoria);

	public abstract List<Categoria> findByDataExclusaoIsNullAndCodigoCategoriaIsNull();

}
