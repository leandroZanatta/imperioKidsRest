package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.PrecoTemporario;
import br.com.sysdesc.imperio.kids.dto.PrecoTemporarioDTO;
import br.com.sysdesc.imperio.kids.service.PrecoTemporarioService;

@CrossOrigin
@RestController
@RequestMapping(path = "/precoTemporario")
public class PrecoTemporarioImpl implements PrecoTemporario {

	@Autowired
	@Lazy
	private PrecoTemporarioService precoTemporarioService;

	@Override
	@GetMapping(path = "/{codigoProduto}")
	public ResponseEntity<Page<PrecoTemporarioDTO>> listar(@PathVariable("codigoProduto") Long codigoProduto,
			@RequestParam("pagina") Long pagina, @RequestParam("registros") Long registros) {

		return ResponseEntity.ok(precoTemporarioService.listar(codigoProduto, pagina, registros));
	}

	@Override
	@PostMapping(path = "/{codigoProduto}")
	public ResponseEntity<Void> salvar(@PathVariable("codigoProduto") Long codigoProduto, @RequestBody PrecoTemporarioDTO precoTemporarioDTO) {

		precoTemporarioService.salvar(codigoProduto, precoTemporarioDTO);

		return ResponseEntity.accepted().build();
	}

	@Override
	@DeleteMapping(path = "/{idPrecoTemporario}")
	public ResponseEntity<Void> exluir(@PathVariable("idPrecoTemporario") Long idPrecoTemporario) {

		precoTemporarioService.exluir(idPrecoTemporario);

		return ResponseEntity.accepted().build();
	}

}
