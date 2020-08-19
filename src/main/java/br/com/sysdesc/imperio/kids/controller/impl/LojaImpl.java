package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Loja;
import br.com.sysdesc.imperio.kids.dto.ProdutoLojaDTO;
import br.com.sysdesc.imperio.kids.service.LojaService;

@CrossOrigin
@RestController
@RequestMapping(path = "/loja")
public class LojaImpl implements Loja {

	@Autowired
	@Lazy
	private LojaService lojaService;

	@Override
	@GetMapping("/produtos")
	public ResponseEntity<Page<ProdutoLojaDTO>> listar(@RequestParam("totalRegistros") Long totalRegistros, @RequestParam("pagina") Long pagina,
			@RequestParam("limit") Long limit) {

		return ResponseEntity.ok(lojaService.listar(totalRegistros, pagina, limit));
	}

}
