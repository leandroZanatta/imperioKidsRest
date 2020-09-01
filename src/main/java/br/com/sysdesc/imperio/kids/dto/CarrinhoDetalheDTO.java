package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CarrinhoDetalheDTO {

	private Long codigoProduto;

	private BigDecimal quantidade;

}
