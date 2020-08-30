package br.com.sysdesc.imperio.kids.repository.projection;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoLojaProjection {

	private Long idProduto;

	private String descricao;

	private String caminho;

	private BigDecimal precoBase;

	private BigDecimal precoTemporario;

}
