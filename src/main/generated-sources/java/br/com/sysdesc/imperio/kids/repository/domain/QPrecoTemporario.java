package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrecoTemporario is a Querydsl query type for PrecoTemporario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrecoTemporario extends EntityPathBase<PrecoTemporario> {

    private static final long serialVersionUID = -986572416L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrecoTemporario precoTemporario = new QPrecoTemporario("precoTemporario");

    public final NumberPath<Long> codigoProduto = createNumber("codigoProduto", Long.class);

    public final DateTimePath<java.util.Date> dataInicio = createDateTime("dataInicio", java.util.Date.class);

    public final DateTimePath<java.util.Date> dataTermino = createDateTime("dataTermino", java.util.Date.class);

    public final NumberPath<Long> idPrecoTemporario = createNumber("idPrecoTemporario", Long.class);

    public final NumberPath<java.math.BigDecimal> preco = createNumber("preco", java.math.BigDecimal.class);

    public final QProduto produto;

    public QPrecoTemporario(String variable) {
        this(PrecoTemporario.class, forVariable(variable), INITS);
    }

    public QPrecoTemporario(Path<? extends PrecoTemporario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrecoTemporario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrecoTemporario(PathMetadata metadata, PathInits inits) {
        this(PrecoTemporario.class, metadata, inits);
    }

    public QPrecoTemporario(Class<? extends PrecoTemporario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

