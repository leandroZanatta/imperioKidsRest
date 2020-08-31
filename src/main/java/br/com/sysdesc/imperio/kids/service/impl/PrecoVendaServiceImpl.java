package br.com.sysdesc.imperio.kids.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.repository.ProdutoRepository;
import br.com.sysdesc.imperio.kids.repository.projection.PrecoVendaProjection;
import br.com.sysdesc.imperio.kids.service.PrecoVendaService;

@Service
public class PrecoVendaServiceImpl implements PrecoVendaService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public BigDecimal buscarPrecoVenda(Long codigoProduto) {

		PrecoVendaProjection precoVendaProjection = produtoRepository.buscarPrecoVenda(codigoProduto);

		if (precoVendaProjection.getPrecoTemporario() != null && precoVendaProjection.getPrecoTemporario().compareTo(BigDecimal.ZERO) > 0) {
			return precoVendaProjection.getPrecoTemporario();
		}

		return precoVendaProjection.getPrecoBase();
	}

}
