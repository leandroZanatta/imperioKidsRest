package br.com.sysdesc.imperio.kids.service;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.PrecoTemporarioDTO;

public interface PrecoTemporarioService {

	public abstract Page<PrecoTemporarioDTO> listar(Long codigoProduto, Long pagina, Long registros);

	public abstract void salvar(Long codigoProduto, PrecoTemporarioDTO precoTemporarioDTO);

	public abstract void exluir(Long idPrecoTemporario);

}
