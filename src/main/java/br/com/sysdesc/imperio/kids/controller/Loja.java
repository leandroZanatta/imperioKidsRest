package br.com.sysdesc.imperio.kids.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.ProdutoLojaDTO;

public interface Loja {

	public abstract ResponseEntity<Page<ProdutoLojaDTO>> listar(Long totalRegistros, Long page, Long limit);

}
