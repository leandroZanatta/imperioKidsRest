package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_carrinhocabecalho")
@SequenceGenerator(name = "GEN_CARRINHOCABECALHO", allocationSize = 1, sequenceName = "GEN_CARRINHOCABECALHO")
public class CarrinhoCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_CARRINHOCABECALHO")
	@Column(name = "id_carrinhocabecalho")
	private Long idCarrinhoCabecalho;

	@Column(name = "cd_cliente")
	private Long codigoCliente;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "fl_vendaefetuada")
	private boolean vendaefetuada;

	@OneToMany(mappedBy = "carrinhoCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CarrinhoDetalhe> carrinhoDetalhes = new ArrayList<>();

}