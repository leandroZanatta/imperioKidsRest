package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaracteristica is a Querydsl query type for Caracteristica
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCaracteristica extends EntityPathBase<Caracteristica> {

    private static final long serialVersionUID = -910784763L;

    public static final QCaracteristica caracteristica = new QCaracteristica("caracteristica");

    public final DatePath<java.util.Date> dataExclusao = createDate("dataExclusao", java.util.Date.class);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> idCaracteristica = createNumber("idCaracteristica", Long.class);

    public QCaracteristica(String variable) {
        super(Caracteristica.class, forVariable(variable));
    }

    public QCaracteristica(Path<? extends Caracteristica> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaracteristica(PathMetadata metadata) {
        super(Caracteristica.class, metadata);
    }

}

