package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImagemProduto is a Querydsl query type for ImagemProduto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QImagemProduto extends EntityPathBase<ImagemProduto> {

    private static final long serialVersionUID = -192525206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImagemProduto imagemProduto = new QImagemProduto("imagemProduto");

    public final StringPath caminho = createString("caminho");

    public final NumberPath<Long> codigoProduto = createNumber("codigoProduto", Long.class);

    public final NumberPath<Long> idImagemProduto = createNumber("idImagemProduto", Long.class);

    public final BooleanPath imagemPrincipal = createBoolean("imagemPrincipal");

    public final QProduto produto;

    public QImagemProduto(String variable) {
        this(ImagemProduto.class, forVariable(variable), INITS);
    }

    public QImagemProduto(Path<? extends ImagemProduto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImagemProduto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImagemProduto(PathMetadata metadata, PathInits inits) {
        this(ImagemProduto.class, metadata, inits);
    }

    public QImagemProduto(Class<? extends ImagemProduto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

