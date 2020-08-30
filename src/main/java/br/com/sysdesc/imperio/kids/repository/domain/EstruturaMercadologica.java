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
@Table(name = "tb_estruturamercadologica")
@SequenceGenerator(name = "GEN_ESTRUTURAMERCADOLOGICA", allocationSize = 1, sequenceName = "GEN_ESTRUTURAMERCADOLOGICA")
public class EstruturaMercadologica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_ESTRUTURAMERCADOLOGICA")
	@Column(name = "id_estruturamercadologica")
	private Long idEstruturaMercadologica;

	@ManyToOne
	@JoinColumn(name = "cd_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "cd_produto")
	private Produto produto;

}