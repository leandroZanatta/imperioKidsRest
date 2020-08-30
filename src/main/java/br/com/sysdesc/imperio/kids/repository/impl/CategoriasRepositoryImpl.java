package br.com.sysdesc.imperio.kids.repository.impl;

import static br.com.sysdesc.imperio.kids.repository.domain.QCategoria.categoria1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

import br.com.sysdesc.imperio.kids.repository.custom.CategoriasRepositoryCustom;
import br.com.sysdesc.imperio.kids.repository.domain.Categoria;
import br.com.sysdesc.imperio.kids.util.StringUtil;

public class CategoriasRepositoryImpl extends QuerydslRepositorySupport implements CategoriasRepositoryCustom {

	public CategoriasRepositoryImpl() {
		super(Categoria.class);
	}

	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {

		super.setEntityManager(entityManager);
	}

	@Override
	public List<Categoria> buscarCategorias(String valorPesquisa, Long pagina, Long registros, Boolean filtrarExcluidos) {

		JPQLQuery<Categoria> query = montarQueryPesquisa(valorPesquisa, filtrarExcluidos);

		query.limit(registros).offset(pagina * registros).orderBy(categoria1.idCategoria.asc());

		return query.select(categoria1).fetch();
	}

	@Override
	public Long contarCategorias(String valorPesquisa, Boolean filtrarExcluidos) {

		return montarQueryPesquisa(valorPesquisa, filtrarExcluidos).fetchCount();
	}

	private JPQLQuery<Categoria> montarQueryPesquisa(String valorPesquisa, Boolean filtrarExcluidos) {

		JPQLQuery<Categoria> query = from(categoria1);

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (!StringUtil.isNullOrEmpty(valorPesquisa)) {

			booleanBuilder.and(categoria1.descricao.likeIgnoreCase(String.format("%%%s%%", valorPesquisa)));
		}

		if (filtrarExcluidos != null && filtrarExcluidos) {

			booleanBuilder.and(categoria1.dataExclusao.isNull());
		}

		if (booleanBuilder.hasValue()) {

			query.where(booleanBuilder);
		}

		return query;
	}

}
