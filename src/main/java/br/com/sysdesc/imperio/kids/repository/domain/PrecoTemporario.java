package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_precotemporario")
@SequenceGenerator(name = "GEN_PRECOTEMPORARIO", allocationSize = 1, sequenceName = "GEN_PRECOTEMPORARIO")
public class PrecoTemporario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_PRECOTEMPORARIO")
	@Column(name = "id_precotemporario")
	private Long idPrecoTemporario;

	@JoinColumn(name = "cd_produto", referencedColumnName = "id_produto")
	@ManyToOne
	private Produto produto;

	@Column(name = "cd_produto", insertable = false, updatable = false)
	private Long codigoProduto;

	@Column(name = "dt_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column(name = "dt_termino")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTermino;

	@Column(name = "vl_preco")
	private BigDecimal preco;

}