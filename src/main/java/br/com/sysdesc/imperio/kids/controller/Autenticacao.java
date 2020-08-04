package br.com.sysdesc.imperio.kids.controller;

import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.AutenticacaoDTO;
import br.com.sysdesc.imperio.kids.dto.UsuarioAutenticadoDTO;

@FunctionalInterface
public interface Autenticacao {

	public ResponseEntity<UsuarioAutenticadoDTO> autenticar(AutenticacaoDTO autenticacaoDTO);
}
