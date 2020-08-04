package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;

@FunctionalInterface
public interface Caracteristicas {

	public ResponseEntity<Page<CaracteristicasDTO>> listar();
}
