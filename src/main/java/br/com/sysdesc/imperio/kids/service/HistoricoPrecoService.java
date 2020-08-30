package br.com.sysdesc.imperio.kids.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.HistoricoPrecoDTO;

public interface HistoricoPrecoService {

	public abstract Page<HistoricoPrecoDTO> listar(Long codigoProduto, Long pagina, Long registros);

	public abstract void alterarPrecoVenda(Long codigoProduto, BigDecimal precoVenda);

}
