package br.com.sysdesc.imperio.kids.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.PrecoTemporario;

@Repository
public interface PrecoTemporarioRepository extends JpaRepository<PrecoTemporario, Long> {

	public abstract Page<PrecoTemporario> findByCodigoProdutoOrderByDataInicioDesc(Long codigoProduto, Pageable page);
}
