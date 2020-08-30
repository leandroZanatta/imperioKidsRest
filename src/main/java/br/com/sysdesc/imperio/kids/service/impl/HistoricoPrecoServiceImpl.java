package br.com.sysdesc.imperio.kids.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.HistoricoPrecoDTO;
import br.com.sysdesc.imperio.kids.repository.HistoricoPrecoRepository;
import br.com.sysdesc.imperio.kids.repository.domain.HistoricoPrecos;
import br.com.sysdesc.imperio.kids.service.HistoricoPrecoService;
import br.com.sysdesc.imperio.kids.service.ProdutosService;
import br.com.sysdesc.imperio.kids.util.DateUtil;

@Service
public class HistoricoPrecoServiceImpl implements HistoricoPrecoService {

	@Autowired
	@Lazy
	private ProdutosService produtosService;

	@Autowired
	@Lazy
	private HistoricoPrecoRepository historicoPrecoRepository;

	@Override
	public Page<HistoricoPrecoDTO> listar(Long codigoProduto, Long pagina, Long registros) {

		return historicoPrecoRepository.findByCodigoProdutoOrderByDataCadastroDesc(codigoProduto,
				PageRequest.of(pagina.intValue(), registros.intValue())).map(this::mapearHistoricoPreco);

	}

	public HistoricoPrecoDTO mapearHistoricoPreco(HistoricoPrecos historicoPrecos) {

		HistoricoPrecoDTO historicoPrecoDTO = new HistoricoPrecoDTO();
		historicoPrecoDTO.setCodigoProduto(historicoPrecos.getCodigoProduto());
		historicoPrecoDTO.setDataCadastro(DateUtil.formatString(historicoPrecos.getDataCadastro(), DateUtil.FORMATO_DD_MM_YYYY_HH_MM_SS));
		historicoPrecoDTO.setIdHistoricoPrecos(historicoPrecos.getIdHistoricoPrecos());
		historicoPrecoDTO.setPreco(historicoPrecos.getPreco());

		return historicoPrecoDTO;
	}

	@Override
	public void alterarPrecoVenda(Long codigoProduto, BigDecimal precoVenda) {

		produtosService.alterarPrecoProduto(codigoProduto, precoVenda);

		HistoricoPrecos historicoPrecos = new HistoricoPrecos();
		historicoPrecos.setCodigoProduto(codigoProduto);
		historicoPrecos.setDataCadastro(DateUtil.getDateTimeNow());
		historicoPrecos.setPreco(precoVenda);

		historicoPrecoRepository.save(historicoPrecos);
	}
}
