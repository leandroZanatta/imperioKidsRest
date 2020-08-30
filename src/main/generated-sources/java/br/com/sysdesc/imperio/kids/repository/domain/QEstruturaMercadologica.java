package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEstruturaMercadologica is a Querydsl query type for EstruturaMercadologica
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEstruturaMercadologica extends EntityPathBase<EstruturaMercadologica> {

    private static final long serialVersionUID = -1762139606L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEstruturaMercadologica estruturaMercadologica = new QEstruturaMercadologica("estruturaMercadologica");

    public final QCategoria categoria;

    public final NumberPath<Long> idEstruturaMercadologica = createNumber("idEstruturaMercadologica", Long.class);

    public final QProduto produto;

    public QEstruturaMercadologica(String variable) {
        this(EstruturaMercadologica.class, forVariable(variable), INITS);
    }

    public QEstruturaMercadologica(Path<? extends EstruturaMercadologica> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEstruturaMercadologica(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEstruturaMercadologica(PathMetadata metadata, PathInits inits) {
        this(EstruturaMercadologica.class, metadata, inits);
    }

    public QEstruturaMercadologica(Class<? extends EstruturaMercadologica> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria"), inits.get("categoria")) : null;
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

