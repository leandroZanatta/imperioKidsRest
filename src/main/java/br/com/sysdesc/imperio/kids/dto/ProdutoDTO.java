package br.com.sysdesc.imperio.kids.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ProdutoDTO {

	private Long idProduto;

	private Long codigoCategoria;

	private Long codigoUnidade;

	private List<EstruturaProdutoDTO> estruturaMercadologica;

	private String descricao;

	private String descricaoConteudo;

	private Boolean controlaEstoque;

	private Boolean produtoOferta;

	private Boolean produtoDestaque;

	private String dataExclusao;

	private BigDecimal preco;

}
