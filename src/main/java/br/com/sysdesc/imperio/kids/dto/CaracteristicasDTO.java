package br.com.sysdesc.imperio.kids.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaracteristicasDTO {

	private Long idCaracteristica;

	private String descricao;

	private String dataExclusao;
}
