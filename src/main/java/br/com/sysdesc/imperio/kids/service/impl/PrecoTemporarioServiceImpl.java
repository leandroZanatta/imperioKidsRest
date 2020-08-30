package br.com.sysdesc.imperio.kids.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.PrecoTemporarioDTO;
import br.com.sysdesc.imperio.kids.repository.PrecoTemporarioRepository;
import br.com.sysdesc.imperio.kids.repository.domain.PrecoTemporario;
import br.com.sysdesc.imperio.kids.service.PrecoTemporarioService;
import br.com.sysdesc.imperio.kids.service.ProdutosService;
import br.com.sysdesc.imperio.kids.util.DateUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class PrecoTemporarioServiceImpl implements PrecoTemporarioService {

	@Autowired
	@Lazy
	private ProdutosService produtosService;

	@Autowired
	@Lazy
	private PrecoTemporarioRepository precoTemporarioRepository;

	@Override
	public Page<PrecoTemporarioDTO> listar(Long codigoProduto, Long pagina, Long registros) {

		return precoTemporarioRepository.findByCodigoProdutoOrderByDataInicioDesc(codigoProduto,
				PageRequest.of(pagina.intValue(), registros.intValue())).map(this::mapearPrecoTemporario);
	}

	public PrecoTemporarioDTO mapearPrecoTemporario(PrecoTemporario precoTemporario) {

		PrecoTemporarioDTO precoTemporarioDTO = new PrecoTemporarioDTO();
		precoTemporarioDTO.setCodigoProduto(precoTemporario.getCodigoProduto());
		precoTemporarioDTO.setDataInicio(DateUtil.formatString(precoTemporario.getDataInicio(), DateUtil.FORMATO_DD_MM_YYYY_HH_MM_SS));
		precoTemporarioDTO.setDataTermino(DateUtil.formatString(precoTemporario.getDataTermino(), DateUtil.FORMATO_DD_MM_YYYY_HH_MM_SS));
		precoTemporarioDTO.setIdPrecoTemporario(precoTemporario.getIdPrecoTemporario());
		precoTemporarioDTO.setPreco(precoTemporario.getPreco());

		return precoTemporarioDTO;
	}

	@Override
	public void salvar(Long codigoProduto, PrecoTemporarioDTO precoTemporarioDTO) {

		PrecoTemporario precoTemporario = buscarPrecoTemporario(precoTemporarioDTO.getIdPrecoTemporario());

		precoTemporario.setProduto(produtosService.buscarProduto(codigoProduto));
		precoTemporario.setDataInicio(DateUtil.parseDate(precoTemporarioDTO.getDataInicio().replace("T", " "), DateUtil.FORMATO_YYYY_MM_DD_HH_MM));
		precoTemporario.setDataTermino(DateUtil.parseDate(precoTemporarioDTO.getDataTermino().replace("T", " "), DateUtil.FORMATO_YYYY_MM_DD_HH_MM));
		precoTemporario.setPreco(precoTemporarioDTO.getPreco());

		precoTemporarioRepository.save(precoTemporario);
	}

	private PrecoTemporario buscarPrecoTemporario(Long idPrecoTemporario) {

		if (!LongUtil.isNullOrZero(idPrecoTemporario)) {
			return precoTemporarioRepository.findById(idPrecoTemporario).orElseThrow(() -> new SysDescException("Preço temporário não encontrado"));
		}

		PrecoTemporario precoTemporario = new PrecoTemporario();
		precoTemporario.setIdPrecoTemporario(idPrecoTemporario);

		return precoTemporario;
	}

	@Override
	public void exluir(Long idPrecoTemporario) {

		precoTemporarioRepository.deleteById(idPrecoTemporario);
	}
}
