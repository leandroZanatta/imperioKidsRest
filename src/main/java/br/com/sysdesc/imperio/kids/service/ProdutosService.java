package br.com.sysdesc.imperio.kids.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.CadastroImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;

public interface ProdutosService {

	public abstract Page<ProdutoDTO> listar(String valorPesquisa, Long pagina, Long registros);

	public abstract void salvar(ProdutoDTO produtoDTO);

	public abstract void excluir(Long codigoCategoria);

	public abstract void reincluir(Long codigoCategoria);

	public abstract void adicionarImagem(CadastroImagemProdutoDTO imagemProdutoDTO);

	public abstract List<ImagemProdutoDTO> listarImagens(Long codigoProduto);
}
