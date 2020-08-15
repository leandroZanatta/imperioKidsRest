package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_categoria")
@SequenceGenerator(name = "GEN_CATEGORIA", allocationSize = 1, sequenceName = "GEN_CATEGORIA")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_CATEGORIA")
	@Column(name = "id_categoria")
	private Long idCategoria;

	@Column(name = "cd_categoria")
	private Long codigoCategoria;

	@Column(name = "dt_exclusao")
	@Temporal(TemporalType.DATE)
	private Date dataExclusao;

	@ManyToOne
	@JoinColumn(name = "cd_categoria", insertable = false, updatable = false)
	private Categoria categoria;

	@Column(name = "tx_descricao")
	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<Categoria> subCategorias;

}