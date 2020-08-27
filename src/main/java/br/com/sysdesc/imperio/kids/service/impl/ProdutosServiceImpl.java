package br.com.sysdesc.imperio.kids.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CadastroImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.DetalheProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.EstruturaProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ImagemDetalheProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;
import br.com.sysdesc.imperio.kids.repository.CategoriasRepository;
import br.com.sysdesc.imperio.kids.repository.ImagemProdutoRepository;
import br.com.sysdesc.imperio.kids.repository.ProdutoRepository;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.repository.domain.ImagemProduto;
import br.com.sysdesc.imperio.kids.repository.domain.Produto;
import br.com.sysdesc.imperio.kids.service.AmazonService;
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

	@Autowired
	@Lazy
	private ImagemProdutoRepository imagemProdutoRepository;

	@Autowired
	@Lazy
	private AmazonService amazonService;

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
			produtoDTO.setProdutoDestaque(produto.getProdutoDestaque());

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
		produto.setProdutoDestaque(produtoDTO.getProdutoDestaque());

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

	@Override
	public void adicionarImagem(CadastroImagemProdutoDTO imagemProdutoDTO) {

		String urlArquivo = amazonService.putFile(imagemProdutoDTO.getImagem(), imagemProdutoDTO.getDescricao());

		ImagemProduto imagemProduto = new ImagemProduto();
		imagemProduto.setCaminho(urlArquivo);
		imagemProduto.setProduto(buscarBuscaProduto(imagemProdutoDTO.getCodigoProduto()));
		imagemProduto.setImagemPrincipal(!existeImagemCadastrada(imagemProdutoDTO.getCodigoProduto()));

		imagemProdutoRepository.save(imagemProduto);

	}

	private boolean existeImagemCadastrada(Long codigoProduto) {

		return imagemProdutoRepository.existsByCodigoProduto(codigoProduto);
	}

	@Override
	public List<ImagemProdutoDTO> listarImagens(Long codigoProduto) {

		return imagemProdutoRepository.findByCodigoProduto(codigoProduto).stream().map(imagem -> {

			ImagemProdutoDTO imagemProdutoDTO = new ImagemProdutoDTO();
			imagemProdutoDTO.setIdImagemProduto(imagem.getIdImagemProduto());
			imagemProdutoDTO.setImagemPrincipal(imagem.getImagemPrincipal());
			imagemProdutoDTO.setLocal(imagem.getCaminho());

			return imagemProdutoDTO;

		}).collect(Collectors.toList());
	}

	@Override
	public void editarImagemPrincipal(Long codigoProduto, Long codigoImagem) {

		List<ImagemProduto> imagens = imagemProdutoRepository.findByCodigoProduto(codigoProduto);

		imagens.stream().forEach(imagem -> imagem.setImagemPrincipal(codigoImagem.equals(imagem.getIdImagemProduto())));

		imagemProdutoRepository.saveAll(imagens);
	}

	@Override
	public DetalheProdutoDTO buscarDetalhes(Long codigoProduto) {
		DetalheProdutoDTO detalheProdutoDTO = new DetalheProdutoDTO();

		Produto produto = buscarBuscaProduto(codigoProduto);

		List<EstruturaProdutoDTO> estrutura = new ArrayList<>();

		criarEstruturaProdutos(produto.getCategoria(), estrutura);

		Collections.reverse(estrutura);

		detalheProdutoDTO.setImagens(buscarImagemProdutos(codigoProduto));
		detalheProdutoDTO.setEstruturaProduto(estrutura);

		return detalheProdutoDTO;
	}

	private void criarEstruturaProdutos(Categoria categoria, List<EstruturaProdutoDTO> estrutura) {

		estrutura.add(new EstruturaProdutoDTO(categoria.getIdCategoria(), categoria.getDescricao()));

		if (categoria.getCategoria() != null) {

			criarEstruturaProdutos(categoria.getCategoria(), estrutura);
		}

	}

	private List<ImagemDetalheProdutoDTO> buscarImagemProdutos(Long codigoProduto) {

		return imagemProdutoRepository.findByCodigoProduto(codigoProduto).stream()
				.map(imagem -> new ImagemDetalheProdutoDTO(imagem.getCaminho(), imagem.getCaminho())).collect(Collectors.toList());
	}

}
