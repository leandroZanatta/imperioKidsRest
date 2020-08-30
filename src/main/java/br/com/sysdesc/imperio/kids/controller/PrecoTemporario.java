package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.PrecoTemporarioDTO;

public interface PrecoTemporario {

	public ResponseEntity<Page<PrecoTemporarioDTO>> listar(Long codigoProduto, Long pagina, Long registros);

	public ResponseEntity<Void> salvar(Long codigoProduto, PrecoTemporarioDTO precoTemporarioDTO);

	public ResponseEntity<Void> exluir(Long idPrecoTemporario);

}
