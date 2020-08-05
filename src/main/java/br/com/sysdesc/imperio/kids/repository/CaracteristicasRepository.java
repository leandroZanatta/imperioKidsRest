package br.com.sysdesc.imperio.kids.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.Caracteristica;

@Repository
public interface CaracteristicasRepository extends JpaRepository<Caracteristica, Long> {

	public abstract boolean existsByDescricao(String descricao);

	public abstract Page<Caracteristica> findByDescricaoLikeIgnoreCase(String valorPesquisa, Pageable page);

}
