package br.com.sysdesc.imperio.kids.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;
import br.com.sysdesc.imperio.kids.repository.CategoriasRepository;
import br.com.sysdesc.imperio.kids.repository.ProdutoRepository;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.repository.domain.Produto;
import br.com.sysdesc.imperio.kids.service.ProdutosService;
import br.com.sysdesc.imperio.kids.util.DateUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class ProdutosServiceImpl implements ProdutosService {

	@Autowired
	@Lazy
	private ProdutoRepository produtoRepository;

	@Autowired
	@Lazy
	private CategoriasRepository categoriasRepository;

	@Override
	public Page<ProdutoDTO> listar(String valorPesquisa, Long pagina, Long registros) {

		if (!StringUtil.isNullOrEmpty(valorPesquisa)) {

			return map(produtoRepository.findByDescricaoLikeIgnoreCase(String.format("%%%s%%", valorPesquisa),
					PageRequest.of(pagina.intValue(), registros.intValue())));
		}

		return map(produtoRepository.findAll(PageRequest.of(pagina.intValue(), registros.intValue())));
	}

	private Page<ProdutoDTO> map(Page<Produto> pagina) {

		return pagina.map(produto -> {
			ProdutoDTO produtoDTO = new ProdutoDTO();

			produtoDTO.setIdProduto(produto.getIdProduto());
			produtoDTO.setDescricao(produto.getDescricao());
			produtoDTO.setDescricaoConteudo(produto.getDescricaoConteudo());
			produtoDTO.setCodigoCategoria(produto.getCategoria().getIdCategoria());
			produtoDTO.setCodigoUnidade(produto.getCodigoUnidade());
			produtoDTO.setControlaEstoque(produto.getControlaEstoque());
			produtoDTO.setProdutoOferta(produto.getProdutoOferta());

			if (produto.getDataExclusao() != null) {
				produtoDTO.setDataExclusao(DateUtil.formatString(produto.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
			}

			return produtoDTO;
		});
	}

	@Override
	public void salvar(ProdutoDTO produtoDTO) {

		if (LongUtil.isNullOrZero(produtoDTO.getIdProduto())) {

			if (StringUtil.isNullOrEmpty(produtoDTO.getDescricao())) {
				throw new SysDescException("O campo descrição não pode ser vazio");
			}

			if (produtoRepository.existsByDescricao(produtoDTO.getDescricao())) {
				throw new SysDescException("Produto já está cadastrado, favor insira outra descrição");
			}
		}

		Produto produto = new Produto();
		produto.setIdProduto(produtoDTO.getIdProduto());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setDescricaoConteudo(produtoDTO.getDescricaoConteudo());
		produto.setCodigoUnidade(produtoDTO.getCodigoUnidade());
		produto.setControlaEstoque(produtoDTO.getControlaEstoque());
		produto.setProdutoOferta(produtoDTO.getProdutoOferta());
		produto.setCategoria(buscarCategoria(produtoDTO.getCodigoCategoria()));

		if (produtoDTO.getDataExclusao() != null) {
			produto.setDataExclusao(DateUtil.parseDate(produtoDTO.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
		}

		produtoRepository.save(produto);

	}

	@Override
	public void excluir(Long codigoProduto) {
		Produto produto = buscarBuscaProduto(codigoProduto);

		produto.setDataExclusao(DateUtil.getDateTimeNow());

		produtoRepository.save(produto);

	}

	@Override
	public void reincluir(Long codigoProduto) {
		Produto produto = buscarBuscaProduto(codigoProduto);

		produto.setDataExclusao(null);

		produtoRepository.save(produto);
	}

	private Categoria buscarCategoria(Long codigoCategoria) {

		return categoriasRepository.findById(codigoCategoria)
				.orElseThrow(() -> new SysDescException("Categoria não encontrada"));
	}

	private Produto buscarBuscaProduto(Long codigoProduto) {

		return produtoRepository.findById(codigoProduto)
				.orElseThrow(() -> new SysDescException("Produto não encontrado"));
	}
}
