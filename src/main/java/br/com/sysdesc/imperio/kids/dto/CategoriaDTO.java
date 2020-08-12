package br.com.sysdesc.imperio.kids.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

	private Long idCategoria;

	private Long codigoCategoria;

	private String descricaoPai;

	private String descricao;
}
