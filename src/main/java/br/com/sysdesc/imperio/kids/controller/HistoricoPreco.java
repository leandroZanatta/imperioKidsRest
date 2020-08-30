package br.com.sysdesc.imperio.kids.controller;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.HistoricoPrecoDTO;

public interface HistoricoPreco {

	public ResponseEntity<Page<HistoricoPrecoDTO>> listar(Long codigoProduto, Long pagina, Long registros);

	public ResponseEntity<Void> alterarPrecoVenda(Long codigoProduto, BigDecimal precoVenda);

}
