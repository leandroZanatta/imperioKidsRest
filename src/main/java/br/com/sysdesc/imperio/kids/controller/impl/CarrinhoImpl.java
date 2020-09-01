package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Carrinho;
import br.com.sysdesc.imperio.kids.dto.CarrinhoCabecalhoDTO;
import br.com.sysdesc.imperio.kids.dto.CarrinhoDetalheDTO;
import br.com.sysdesc.imperio.kids.service.CarrinhoService;

@CrossOrigin
@RestController
@RequestMapping(path = "/carrinho")
public class CarrinhoImpl implements Carrinho {

	@Autowired
	private CarrinhoService carrinhoService;

	@Override
	@GetMapping
	public ResponseEntity<CarrinhoCabecalhoDTO> gerarCarrinho(@RequestParam(value = "codigoCarrinho", required = false) Long codigoCarrinho) {

		return ResponseEntity.ok(carrinhoService.gerarCarrinho(codigoCarrinho));
	}

	@Override
	@PostMapping(path = "/{codigoCarrinho}")
	public ResponseEntity<CarrinhoCabecalhoDTO> incluirProduto(@PathVariable("codigoCarrinho") Long codigoCarrinho,
			@RequestBody CarrinhoDetalheDTO carrinhoDetalheDTO) {

		return ResponseEntity.ok(carrinhoService.incluirProduto(codigoCarrinho, carrinhoDetalheDTO));
	}

}
