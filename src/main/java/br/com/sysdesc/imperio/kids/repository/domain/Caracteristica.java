package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
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
@Table(name = "tb_caracteristica")
@SequenceGenerator(name = "GEN_CARACTERISTICA", allocationSize = 1, sequenceName = "GEN_CARACTERISTICA")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_CARACTERISTICA")
	@Column(name = "id_caracteristica")
	private Long idCaracteristica;

	@Column(name = "dt_exclusao")
	@Temporal(TemporalType.DATE)
	private Date dataExclusao;

	@Column(name = "tx_descricao")
	private String descricao;

}