package br.com.sysdesc.imperio.kids.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.HistoricoPrecos;

@Repository
public interface HistoricoPrecoRepository extends JpaRepository<HistoricoPrecos, Long> {

	public abstract Page<HistoricoPrecos> findByCodigoProdutoOrderByDataCadastroDesc(Long codigoProduto, Pageable page);

}
