package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class DetalheProdutoDTO {

	private Long idProduto;

	private String nome;

	private String descricao;

	private BigDecimal precoBase;

	private List<ImagemDetalheProdutoDTO> imagens;

	private List<EstruturaProdutoDTO> estruturaProduto;
}
