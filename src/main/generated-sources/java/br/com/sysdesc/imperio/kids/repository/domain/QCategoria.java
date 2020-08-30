package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoria is a Querydsl query type for Categoria
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoria extends EntityPathBase<Categoria> {

    private static final long serialVersionUID = -1509021962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoria categoria1 = new QCategoria("categoria1");

    public final QCategoria categoria;

    public final NumberPath<Long> codigoCategoria = createNumber("codigoCategoria", Long.class);

    public final DatePath<java.util.Date> dataExclusao = createDate("dataExclusao", java.util.Date.class);

    public final StringPath descricao = createString("descricao");

    public final ListPath<EstruturaMercadologica, QEstruturaMercadologica> estruturaMercadologicas = this.<EstruturaMercadologica, QEstruturaMercadologica>createList("estruturaMercadologicas", EstruturaMercadologica.class, QEstruturaMercadologica.class, PathInits.DIRECT2);

    public final NumberPath<Long> idCategoria = createNumber("idCategoria", Long.class);

    public final ListPath<Produto, QProduto> produtos = this.<Produto, QProduto>createList("produtos", Produto.class, QProduto.class, PathInits.DIRECT2);

    public final ListPath<Categoria, QCategoria> subCategorias = this.<Categoria, QCategoria>createList("subCategorias", Categoria.class, QCategoria.class, PathInits.DIRECT2);

    public QCategoria(String variable) {
        this(Categoria.class, forVariable(variable), INITS);
    }

    public QCategoria(Path<? extends Categoria> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoria(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoria(PathMetadata metadata, PathInits inits) {
        this(Categoria.class, metadata, inits);
    }

    public QCategoria(Class<? extends Categoria> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria"), inits.get("categoria")) : null;
    }

}

