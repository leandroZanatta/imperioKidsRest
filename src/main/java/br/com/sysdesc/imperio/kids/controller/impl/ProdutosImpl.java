package br.com.sysdesc.imperio.kids.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Produtos;
import br.com.sysdesc.imperio.kids.dto.CadastroImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ImagemProdutoDTO;
import br.com.sysdesc.imperio.kids.dto.ProdutoDTO;
import br.com.sysdesc.imperio.kids.service.ProdutosService;

@CrossOrigin
@RestController
@RequestMapping(path = "/produtos")
public class ProdutosImpl implements Produtos {

	@Autowired
	@Lazy
	private ProdutosService produtosService;

	@Override
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> listar(@RequestParam("valorPesquisa") String valorPesquisa,
			@RequestParam("pagina") Long pagina, @RequestParam("registros") Long registros) {

		return ResponseEntity.ok(produtosService.listar(valorPesquisa, pagina, registros));
	}

	@Override
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody ProdutoDTO produtoDTO) {
		produtosService.salvar(produtoDTO);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping(path = "/{codigoProduto}")
	public ResponseEntity<Void> excluir(@PathVariable("codigoProduto") Long codigoProduto) {

		produtosService.excluir(codigoProduto);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@Override
	@PutMapping(path = "/{codigoProduto}")
	public ResponseEntity<Void> reincluir(@PathVariable("codigoProduto") Long codigoProduto) {

		produtosService.reincluir(codigoProduto);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@Override
	@PostMapping("/imagem")
	public ResponseEntity<Void> adicionarImagem(@RequestBody CadastroImagemProdutoDTO imagemProdutoDTO) {
		produtosService.adicionarImagem(imagemProdutoDTO);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/imagem/{codigoProduto}")
	public ResponseEntity<List<ImagemProdutoDTO>> listarImagens(@PathVariable("codigoProduto") Long codigoProduto) {

		return ResponseEntity.ok(produtosService.listarImagens(codigoProduto));
	}

}
