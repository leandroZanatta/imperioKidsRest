package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoLojaDTO {

	private String descricao;

	private String imageType;

	private String imageContent;

	private Boolean produtoPromocao;

	private BigDecimal precoBase;

}
