package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoricoPrecos is a Querydsl query type for HistoricoPrecos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoricoPrecos extends EntityPathBase<HistoricoPrecos> {

    private static final long serialVersionUID = 211249047L;

    public static final QHistoricoPrecos historicoPrecos = new QHistoricoPrecos("historicoPrecos");

    public final NumberPath<Long> codigoProduto = createNumber("codigoProduto", Long.class);

    public final DateTimePath<java.util.Date> dataCadastro = createDateTime("dataCadastro", java.util.Date.class);

    public final NumberPath<Long> idHistoricoPrecos = createNumber("idHistoricoPrecos", Long.class);

    public final NumberPath<java.math.BigDecimal> preco = createNumber("preco", java.math.BigDecimal.class);

    public QHistoricoPrecos(String variable) {
        super(HistoricoPrecos.class, forVariable(variable));
    }

    public QHistoricoPrecos(Path<? extends HistoricoPrecos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoricoPrecos(PathMetadata metadata) {
        super(HistoricoPrecos.class, metadata);
    }

}

