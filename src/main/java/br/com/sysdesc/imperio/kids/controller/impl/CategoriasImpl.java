package br.com.sysdesc.imperio.kids.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sysdesc.imperio.kids.controller.Categorias;
import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;
import br.com.sysdesc.imperio.kids.service.CategoriasService;

@CrossOrigin
@RestController
@RequestMapping(path = "/categorias")
public class CategoriasImpl implements Categorias {

	@Autowired
	@Lazy
	private CategoriasService categoriasService;

	@Override
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> listar(@RequestParam("valorPesquisa") String valorPesquisa,
			@RequestParam("pagina") Long pagina, @RequestParam("registros") Long registros) {

		return ResponseEntity.ok(categoriasService.listar(valorPesquisa, pagina, registros));
	}

	@Override
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody CategoriaDTO categoriaDTO) {
		categoriasService.salvar(categoriaDTO);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
