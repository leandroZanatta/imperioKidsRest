package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoPrecoDTO {

	private Long idHistoricoPrecos;

	private Long codigoProduto;

	private String dataCadastro;

	private BigDecimal preco;
}
