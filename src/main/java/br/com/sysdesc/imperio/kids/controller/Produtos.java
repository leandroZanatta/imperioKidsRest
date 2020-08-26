package br.com.sysdesc.imperio.kids.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CadastroImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.DetalheProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;

public interface Produtos {

	public ResponseEntity<Page<ProdutoDTO>> listar(String valorPesquisa,
			Long pagina, Long registros);

	public ResponseEntity<List<ImagemProdutoDTO>> listarImagens(Long codigoProduto);

	public ResponseEntity<DetalheProdutoDTO> buscarDetalhes(Long codigoProduto);

	public ResponseEntity<Void> salvar(ProdutoDTO produtoDTO);

	public ResponseEntity<Void> excluir(Long codigoCategoria);

	public ResponseEntity<Void> reincluir(Long codigoCategoria);

	public ResponseEntity<Void> adicionarImagem(CadastroImagemProdutoDTO imagemProdutoDTO);

	public ResponseEntity<Void> editarImagemPrincipal(Long codigoProduto, Long codigoImagem);
}
