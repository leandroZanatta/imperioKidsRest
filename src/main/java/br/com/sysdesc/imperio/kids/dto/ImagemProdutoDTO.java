package br.com.sysdesc.imperio.kids.dto;

import lombok.Data;

@Data
public class ImagemProdutoDTO {

	private String content;

	private String local;

	private String type;

	private Long idImagemProduto;

	private Boolean imagemPrincipal;
}
