package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;

public interface Produtos {

	public ResponseEntity<Page<ProdutoDTO>> listar(String valorPesquisa,
			Long pagina, Long registros);

	public ResponseEntity<Void> salvar(ProdutoDTO produtoDTO);

	public ResponseEntity<Void> excluir(Long codigoCategoria);

	public ResponseEntity<Void> reincluir(Long codigoCategoria);
}
