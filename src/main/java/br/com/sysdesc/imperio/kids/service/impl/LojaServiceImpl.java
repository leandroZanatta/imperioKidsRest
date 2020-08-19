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
import br.com.sysdesc.imperio.kids.util.ImageUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;

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
			produtoLojaDTO.setDescricao(produto.getDescricao());
			produtoLojaDTO.setProdutoPromocao(Boolean.FALSE);
			produtoLojaDTO.setPrecoBase(BigDecimal.TEN);

			if (!StringUtil.isNullOrEmpty(produto.getCaminho())) {
				produtoLojaDTO.setImageType(ImageUtil.getType(produto.getCaminho()));
				produtoLojaDTO.setImageContent(ImageUtil.criarBase64(produto.getCaminho()));
			}

			return produtoLojaDTO;
		}).collect(Collectors.toList()), PageRequest.of(pagina.intValue(), limit.intValue()), totalRegistros);
	}

}
