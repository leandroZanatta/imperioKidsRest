package br.com.sysdesc.imperio.kids.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.ImagemProduto;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {

	public abstract boolean existsByCodigoProduto(Long codigoProduto);

	public abstract List<ImagemProduto> findByCodigoProduto(Long codigoProduto);

}
