package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;

public interface Caracteristicas {

	public ResponseEntity<Page<CaracteristicasDTO>> listar(String valorPesquisa,
			Long pagina, Long registros);

	public ResponseEntity<Void> salvar(CaracteristicasDTO caracteristicasDTO);
}
