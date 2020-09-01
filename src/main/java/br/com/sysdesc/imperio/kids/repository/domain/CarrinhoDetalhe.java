package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "tb_carrinhodetalhe")
@SequenceGenerator(name = "GEN_CARRINHODETALHE", allocationSize = 1, sequenceName = "GEN_CARRINHODETALHE")
public class CarrinhoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_CARRINHODETALHE")
	@Column(name = "id_carrinhodetalhe")
	private Long idCarrinhoDetalhe;

	@Column(name = "cd_carrinhocabecalho")
	private Long codigoCarrinhoCabecalho;

	@ManyToOne
	@JoinColumn(name = "cd_carrinhocabecalho", insertable = false, updatable = false)
	private CarrinhoCabecalho carrinhoCabecalho;

	@Column(name = "cd_produto")
	private Long codigoProduto;

	@Column(name = "nr_quantidade")
	private BigDecimal quantidade;
}