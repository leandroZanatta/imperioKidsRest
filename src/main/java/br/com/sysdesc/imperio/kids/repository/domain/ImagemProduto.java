package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_imagemproduto")
@SequenceGenerator(name = "GEN_IMAGEMPRODUTO", allocationSize = 1, sequenceName = "GEN_IMAGEMPRODUTO")
public class ImagemProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_IMAGEMPRODUTO")
	@Column(name = "id_imagemproduto")
	private Long idImagemProduto;

	@JoinColumn(name = "cd_produto", referencedColumnName = "id_produto")
	@ManyToOne
	private Produto produto;

	@Column(name = "cd_produto", insertable = false, updatable = false)
	private Long codigoProduto;

	@Column(name = "tx_caminho")
	private String caminho;

	@Column(name = "fl_imagemprincipal")
	private boolean imagemPrincipal;

}