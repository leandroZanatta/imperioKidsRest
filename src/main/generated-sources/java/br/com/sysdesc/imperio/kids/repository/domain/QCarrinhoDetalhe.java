package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarrinhoDetalhe is a Querydsl query type for CarrinhoDetalhe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarrinhoDetalhe extends EntityPathBase<CarrinhoDetalhe> {

    private static final long serialVersionUID = 2072362004L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCarrinhoDetalhe carrinhoDetalhe = new QCarrinhoDetalhe("carrinhoDetalhe");

    public final QCarrinhoCabecalho carrinhoCabecalho;

    public final NumberPath<Long> codigoCarrinhoCabecalho = createNumber("codigoCarrinhoCabecalho", Long.class);

    public final NumberPath<Long> codigoProduto = createNumber("codigoProduto", Long.class);

    public final NumberPath<Long> idCarrinhoDetalhe = createNumber("idCarrinhoDetalhe", Long.class);

    public final NumberPath<java.math.BigDecimal> quantidade = createNumber("quantidade", java.math.BigDecimal.class);

    public QCarrinhoDetalhe(String variable) {
        this(CarrinhoDetalhe.class, forVariable(variable), INITS);
    }

    public QCarrinhoDetalhe(Path<? extends CarrinhoDetalhe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCarrinhoDetalhe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCarrinhoDetalhe(PathMetadata metadata, PathInits inits) {
        this(CarrinhoDetalhe.class, metadata, inits);
    }

    public QCarrinhoDetalhe(Class<? extends CarrinhoDetalhe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carrinhoCabecalho = inits.isInitialized("carrinhoCabecalho") ? new QCarrinhoCabecalho(forProperty("carrinhoCabecalho")) : null;
    }

}

