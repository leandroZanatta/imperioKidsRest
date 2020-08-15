package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Caracteristicas;
import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;
import br.com.sysdesc.imperio.kids.service.CaracteristicasService;

@CrossOrigin
@RestController
@RequestMapping(path = "/caracteristicas")
public class CaracteristicasImpl implements Caracteristicas {

	@Autowired
	@Lazy
	private CaracteristicasService caracteristicasService;

	@Override
	@GetMapping
	public ResponseEntity<Page<CaracteristicasDTO>> listar(@RequestParam("valorPesquisa") String valorPesquisa,
			@RequestParam("pagina") Long pagina, @RequestParam("registros") Long registros) {

		return ResponseEntity.ok(caracteristicasService.listar(valorPesquisa, pagina, registros));
	}

	@Override
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody CaracteristicasDTO caracteristicasDTO) {
		caracteristicasService.salvar(caracteristicasDTO);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping(path = "/{codigoCaracteristica}")
	public ResponseEntity<Void> excluir(@PathVariable("codigoCaracteristica") Long codigoCaracteristica) {

		caracteristicasService.excluir(codigoCaracteristica);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@Override
	@PutMapping(path = "/{codigoCaracteristica}")
	public ResponseEntity<Void> reincluir(@PathVariable("codigoCaracteristica") Long codigoCaracteristica) {

		caracteristicasService.reincluir(codigoCaracteristica);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
