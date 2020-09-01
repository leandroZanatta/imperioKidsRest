package br.com.sysdesc.imperio.kids.controller;

import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CarrinhoCabecalhoDTO;
import br.com.sysdesc.imperio.kids.dto.CarrinhoDetalheDTO;

public interface Carrinho {

	public ResponseEntity<CarrinhoCabecalhoDTO> gerarCarrinho(Long codigoCarrinho);

	public ResponseEntity<CarrinhoCabecalhoDTO> incluirProduto(Long codigoCarrinho, CarrinhoDetalheDTO carrinhoDetalheDTO);
}
