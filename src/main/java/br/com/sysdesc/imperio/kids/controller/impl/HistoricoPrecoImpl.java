package br.com.sysdesc.imperio.kids.controller.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.HistoricoPreco;
import br.com.sysdesc.imperio.kids.dto.HistoricoPrecoDTO;
import br.com.sysdesc.imperio.kids.service.HistoricoPrecoService;

@CrossOrigin
@RestController
@RequestMapping(path = "/historicoPreco")
public class HistoricoPrecoImpl implements HistoricoPreco {

	@Autowired
	@Lazy
	private HistoricoPrecoService historicoPrecoService;

	@Override
	@GetMapping(path = "/{codigoProduto}")
	public ResponseEntity<Page<HistoricoPrecoDTO>> listar(@PathVariable("codigoProduto") Long codigoProduto,
			@RequestParam("pagina") Long pagina, @RequestParam("registros") Long registros) {

		return ResponseEntity.ok(historicoPrecoService.listar(codigoProduto, pagina, registros));
	}

	@Override
	@PostMapping(path = "/{codigoProduto}")
	public ResponseEntity<Void> alterarPrecoVenda(@PathVariable("codigoProduto") Long codigoProduto, @RequestBody BigDecimal precoVenda) {

		historicoPrecoService.alterarPrecoVenda(codigoProduto, precoVenda);

		return ResponseEntity.accepted().build();
	}

}
