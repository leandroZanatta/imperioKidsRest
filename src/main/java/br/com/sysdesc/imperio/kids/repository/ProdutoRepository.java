package br.com.sysdesc.imperio.kids.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.custom.ProdutoRepositoryCustom;
import br.com.sysdesc.imperio.kids.repository.domain.Produto;

@Repository
public interface ProdutoRepository extends ProdutoRepositoryCustom, JpaRepository<Produto, Long> {

	public abstract Page<Produto> findByDescricaoLikeIgnoreCase(String descricao, Pageable page);

	public abstract boolean existsByDescricao(String descricao);

}
