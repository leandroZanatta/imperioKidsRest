package br.com.sysdesc.imperio.kids.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

	private Long idCategoria;

	private Long numeroProdutos;

	private Long codigoCategoria;

	private List<EstruturaProdutoDTO> estruturaMercadologica;

	private String descricao;

	private String dataExclusao;
}
