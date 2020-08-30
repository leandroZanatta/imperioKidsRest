package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_historicoprecos")
@SequenceGenerator(name = "GEN_HISTORICOPRECOS", allocationSize = 1, sequenceName = "GEN_HISTORICOPRECOS")
public class HistoricoPrecos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_HISTORICOPRECOS")
	@Column(name = "id_historicoprecos")
	private Long idHistoricoPrecos;

	@Column(name = "cd_produto")
	private Long codigoProduto;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "vl_preco")
	private BigDecimal preco;

}