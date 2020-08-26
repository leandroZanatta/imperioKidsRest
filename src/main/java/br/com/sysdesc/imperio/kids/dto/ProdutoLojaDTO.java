package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoLojaDTO {

	private Long idProduto;

	private String descricao;

	private String imageUrl;

	private Boolean produtoPromocao;

	private BigDecimal precoBase;

}
