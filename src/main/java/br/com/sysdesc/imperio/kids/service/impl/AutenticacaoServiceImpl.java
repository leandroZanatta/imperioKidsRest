package br.com.sysdesc.imperio.kids.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.AutenticacaoDTO;
import br.com.sysdesc.imperio.kids.dto.PermisaoProgramaDTO;
import br.com.sysdesc.imperio.kids.dto.UsuarioAutenticadoDTO;
import br.com.sysdesc.imperio.kids.repository.UsuarioRepository;
import br.com.sysdesc.imperio.kids.repository.domain.PermissaoPrograma;
import br.com.sysdesc.imperio.kids.repository.domain.Usuario;
import br.com.sysdesc.imperio.kids.service.AutenticacaoService;
import br.com.sysdesc.imperio.kids.util.CryptoUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

	@Autowired
	@Lazy
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioAutenticadoDTO autenticar(AutenticacaoDTO autenticacaoDTO) {

		if (StringUtil.isNullOrEmpty(autenticacaoDTO.getUsuario())) {

			throw new SysDescException("Usuário não Informado.");
		}

		if (StringUtil.isNullOrEmpty(autenticacaoDTO.getSenha())) {

			throw new SysDescException("Senha não informada.");

		}

		Optional<Usuario> usuario = usuarioRepository.findByLoginUsuarioAndSenha(autenticacaoDTO.getUsuario(),
				CryptoUtil.toMD5(autenticacaoDTO.getSenha()));

		if (!usuario.isPresent()) {

			throw new SysDescException("Usuário ou senha inválida");
		}

		UsuarioAutenticadoDTO usuarioAutenticadoDTO = new UsuarioAutenticadoDTO();
		usuarioAutenticadoDTO.setIdUsuario(usuario.get().getIdUsuario());
		usuarioAutenticadoDTO.setNome(usuario.get().getNome());
		usuarioAutenticadoDTO.setPermissaoProgramas(montarPermissoesUsuario(usuario.get()));

		return usuarioAutenticadoDTO;
	}

	private List<PermisaoProgramaDTO> montarPermissoesUsuario(Usuario usuario) {
		Set<PermisaoProgramaDTO> permissaoProgramas = new HashSet<>();

		usuario.getPermissaoProgramas().forEach(permissao -> montarPermissao(permissao, permissaoProgramas));

		usuario.getPerfilUsuarios().forEach(perfilUsuarios -> perfilUsuarios.getPerfil().getPermissaoProgramas()
				.forEach(permissao -> montarPermissao(permissao, permissaoProgramas)));

		return new ArrayList<>(permissaoProgramas);
	}

	private void montarPermissao(PermissaoPrograma permissao, Set<PermisaoProgramaDTO> permissaoProgramas) {

		permissaoProgramas.add(montarPermissaoDTO(permissao));
	}

	private PermisaoProgramaDTO montarPermissaoDTO(PermissaoPrograma permissao) {

		return new PermisaoProgramaDTO(permissao.getCodigoPrograma(), permissao.getFlagLeitura(),
				permissao.getFlagCadastro(), permissao.getFlagExclusao());
	}
}
