package br.com.sysdesc.imperio.kids.repository.projection;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PrecoVendaProjection {

	private Long idProduto;

	private BigDecimal precoBase;

	private BigDecimal precoTemporario;

}
