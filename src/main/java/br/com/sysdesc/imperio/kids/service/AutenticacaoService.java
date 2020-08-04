package br.com.sysdesc.imperio.kids.service;

import br.com.sysdesc.imperio.kids.dto.AutenticacaoDTO;
import br.com.sysdesc.imperio.kids.dto.UsuarioAutenticadoDTO;

@FunctionalInterface
public interface AutenticacaoService {

	public UsuarioAutenticadoDTO autenticar(AutenticacaoDTO autenticacaoDTO);
}
