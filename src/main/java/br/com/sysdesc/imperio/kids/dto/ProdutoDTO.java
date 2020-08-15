package br.com.sysdesc.imperio.kids.dto;

import lombok.Data;

@Data
public class ProdutoDTO {

	private Long idProduto;

	private Long codigoCategoria;

	private Long codigoUnidade;

	private String descricao;

	private String descricaoConteudo;

	private Boolean controlaEstoque;

	private Boolean produtoOferta;

	private String dataExclusao;

}
