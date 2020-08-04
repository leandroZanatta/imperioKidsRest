package br.com.sysdesc.imperio.kids.dto;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioAutenticadoDTO {

	private Long idUsuario;

	private String nome;

	private List<PermisaoProgramaDTO> permissaoProgramas;
}
