package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	@Column(name = "tx_descricao")
	private String descricao;

}