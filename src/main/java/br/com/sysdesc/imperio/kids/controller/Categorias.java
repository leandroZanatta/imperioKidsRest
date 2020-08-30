package br.com.sysdesc.imperio.kids.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import br.com.sysdesc.imperio.kids.dto.CategoriaDTO;
import br.com.sysdesc.imperio.kids.dto.EstruturaCategoriaDTO;

public interface Categorias {

	public ResponseEntity<Page<CategoriaDTO>> listar(String valorPesquisa,
			Long pagina, Long registros, Boolean filtrarExcluidos);

	public ResponseEntity<CategoriaDTO> buscarPorId(Long codigoCategoria);

	public ResponseEntity<List<EstruturaCategoriaDTO>> obterEstrutura();

	public ResponseEntity<Void> salvar(CategoriaDTO categoriaDTO);

	public ResponseEntity<Void> excluir(Long codigoCategoria);

	public ResponseEntity<Void> reincluir(Long codigoCategoria);
}
