package br.com.sysdesc.imperio.kids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysdesc.imperio.kids.repository.domain.CarrinhoCabecalho;

@Repository
public interface CarrinhoCabecalhoRepository extends JpaRepository<CarrinhoCabecalho, Long> {

}
