package br.com.sysdesc.imperio.kids.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstruturaCategoriaDTO {

	private Long codigoCategoria;

	private String descricao;

	private List<EstruturaCategoriaDTO> subcategorias = new ArrayList<>();
}
