package br.com.sysdesc.imperio.kids.service;

import java.math.BigDecimal;

public interface PrecoVendaService {

	public abstract BigDecimal buscarPrecoVenda(Long codigoProduto);

}
