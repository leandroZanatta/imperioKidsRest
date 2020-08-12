package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;

public interface Categorias {

	public ResponseEntity<Page<CategoriaDTO>> listar(String valorPesquisa,
			Long pagina, Long registros);

	public ResponseEntity<Void> salvar(CategoriaDTO categoriaDTO);
}
