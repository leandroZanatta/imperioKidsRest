package br.com.sysdesc.imperio.kids.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "tb_produto")
@SequenceGenerator(name = "GEN_PRODUTO", allocationSize = 1, sequenceName = "GEN_PRODUTO")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_PRODUTO")
	@Column(name = "id_produto")
	private Long idProduto;

	@JoinColumn(name = "cd_categoria", referencedColumnName = "id_categoria")
	@ManyToOne
	private Categoria categoria;

	@Column(name = "tx_descricao")
	private String descricao;

	@Column(name = "tx_descricaoconteudo")
	private String descricaoConteudo;

	@Column(name = "fl_controlaestoque")
	private Boolean controlaEstoque;

	@Column(name = "fl_produtooferta")
	private Boolean produtoOferta;

	@Column(name = "fl_produtodestaque")
	private Boolean produtoDestaque;

	@Column(name = "cd_unidade")
	private Long codigoUnidade;

	@Column(name = "vl_preco")
	private BigDecimal preco;

	@Column(name = "dt_exclusao")
	@Temporal(TemporalType.DATE)
	private Date dataExclusao;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EstruturaMercadologica> estruturaMercadologicas;

	@OneToMany(mappedBy = "produto")
	private List<PrecoTemporario> precosTemporarios;
}