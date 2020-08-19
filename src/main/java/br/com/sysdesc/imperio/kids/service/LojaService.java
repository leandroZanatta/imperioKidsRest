package br.com.sysdesc.imperio.kids.service;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.ProdutoLojaDTO;

public interface LojaService {

	public abstract Page<ProdutoLojaDTO> listar(Long totalRegistros, Long pagina, Long limit);

}
