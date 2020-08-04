package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Caracteristicas;
import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;
import br.com.sysdesc.imperio.kids.service.CaracteristicasService;

@CrossOrigin
@RestController
public class CaracteristicasImpl implements Caracteristicas {

	@Autowired
	@Lazy
	private CaracteristicasService caracteristicasService;

	@Override
	@GetMapping(path = "/caracteristicas")
	public ResponseEntity<Page<CaracteristicasDTO>> listar() {

		return ResponseEntity.ok(caracteristicasService.listar());
	}

}
