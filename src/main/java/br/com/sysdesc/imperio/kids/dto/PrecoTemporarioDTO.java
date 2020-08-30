package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecoTemporarioDTO {

	private Long idPrecoTemporario;

	private Long codigoProduto;

	private String dataInicio;

	private String dataTermino;

	private BigDecimal preco;
}
