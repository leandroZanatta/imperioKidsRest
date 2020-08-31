package br.com.sysdesc.imperio.kids.repository.impl;

import static br.com.sysdesc.imperio.kids.repository.domain.QImagemProduto.imagemProduto;
import static br.com.sysdesc.imperio.kids.repository.domain.QPrecoTemporario.precoTemporario;
import static br.com.sysdesc.imperio.kids.repository.domain.QProduto.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.PostgreSQLTemplates;

import br.com.sysdesc.imperio.kids.repository.custom.ProdutoRepositoryCustom;
import br.com.sysdesc.imperio.kids.repository.domain.Produto;
import br.com.sysdesc.imperio.kids.repository.projection.PrecoVendaProjection;
import br.com.sysdesc.imperio.kids.repository.projection.ProdutoLojaProjection;

public class ProdutoRepositoryImpl extends QuerydslRepositorySupport implements ProdutoRepositoryCustom {

	public ProdutoRepositoryImpl() {
		super(Produto.class);
	}

	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {

		super.setEntityManager(entityManager);
	}

	@Override
	public List<ProdutoLojaProjection> buscarProdutos(Long pagina, Long limit) {

		JPASQLQuery<ProdutoLojaProjection> sql = montarQueryProdutos();

		sql.select(Projections.fields(ProdutoLojaProjection.class, produto.idProduto, produto.descricao, imagemProduto.caminho));

		return sql.fetch();
	}

	@Override
	public Long contarProdutos() {

		return montarQueryProdutos().fetchCount();
	}

	private JPASQLQuery<ProdutoLojaProjection> montarQueryProdutos() {

		JPASQLQuery<ProdutoLojaProjection> sql = new JPASQLQuery<>(getEntityManager(), PostgreSQLTemplates.DEFAULT);

		sql.from(produto);

		sql.leftJoin(imagemProduto).on(produto.idProduto.eq(imagemProduto.codigoProduto).and(imagemProduto.imagemPrincipal));

		return sql;
	}

	@Override
	public PrecoVendaProjection buscarPrecoVenda(Long codigoProduto) {
		JPASQLQuery<PrecoVendaProjection> sql = new JPASQLQuery<>(getEntityManager(), PostgreSQLTemplates.DEFAULT);

		sql.from(produto);

		sql.leftJoin(precoTemporario).on(produto.idProduto.eq(precoTemporario.codigoProduto)
				.and(DateTimeExpression.currentTimestamp().between(precoTemporario.dataInicio, precoTemporario.dataTermino)));

		sql.select(Projections.fields(PrecoVendaProjection.class, produto.idProduto, produto.preco.as("precoBase"),
				precoTemporario.preco.as("precoTemporario")));

		return sql.fetchFirst();
	}
}
