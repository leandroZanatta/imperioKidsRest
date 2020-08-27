package br.com.sysdesc.imperio.kids.dto;

import java.util.List;

import lombok.Data;

@Data
public class DetalheProdutoDTO {

	private String nome;

	private String descricao;

	private List<ImagemDetalheProdutoDTO> imagens;

	private List<EstruturaProdutoDTO> estruturaProduto;
}
