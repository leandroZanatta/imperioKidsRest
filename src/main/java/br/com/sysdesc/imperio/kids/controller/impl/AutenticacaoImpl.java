package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Autenticacao;
import br.com.sysdesc.imperio.kids.dto.AutenticacaoDTO;
import br.com.sysdesc.imperio.kids.dto.UsuarioAutenticadoDTO;
import br.com.sysdesc.imperio.kids.service.AutenticacaoService;

@CrossOrigin
@RestController
public class AutenticacaoImpl implements Autenticacao {

	@Autowired
	@Lazy
	private AutenticacaoService autenticacaoService;

	@Override
	@PostMapping(path = "/autenticacao")
	public ResponseEntity<UsuarioAutenticadoDTO> autenticar(@RequestBody AutenticacaoDTO autenticacaoDTO) {

		return ResponseEntity.ok(autenticacaoService.autenticar(autenticacaoDTO));
	}

}
