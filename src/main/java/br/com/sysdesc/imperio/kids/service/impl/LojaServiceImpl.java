package br.com.sysdesc.imperio.kids.service.impl;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.ProdutoLojaDTO;
import br.com.sysdesc.imperio.kids.repository.ProdutoRepository;
import br.com.sysdesc.imperio.kids.service.LojaService;
import br.com.sysdesc.imperio.kids.util.LongUtil;

@Service
public class LojaServiceImpl implements LojaService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Page<ProdutoLojaDTO> listar(Long totalRegistros, Long pagina, Long limit) {

		if (LongUtil.isNullOrZero(totalRegistros)) {

			totalRegistros = produtoRepository.contarProdutos();
		}

		return new PageImpl<>(produtoRepository.buscarProdutos(pagina, limit).stream().map(produto -> {

			ProdutoLojaDTO produtoLojaDTO = new ProdutoLojaDTO();
			produtoLojaDTO.setIdProduto(produto.getIdProduto());
			produtoLojaDTO.setDescricao(produto.getDescricao());
			produtoLojaDTO.setProdutoPromocao(Boolean.FALSE);
			produtoLojaDTO.setPrecoBase(BigDecimal.TEN);
			produtoLojaDTO.setImageUrl(produto.getCaminho());

			return produtoLojaDTO;
		}).collect(Collectors.toList()), PageRequest.of(pagina.intValue(), limit.intValue()), totalRegistros);
	}

}
