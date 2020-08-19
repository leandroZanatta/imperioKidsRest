package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduto is a Querydsl query type for Produto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduto extends EntityPathBase<Produto> {

    private static final long serialVersionUID = -799823492L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduto produto = new QProduto("produto");

    public final QCategoria categoria;

    public final NumberPath<Long> codigoUnidade = createNumber("codigoUnidade", Long.class);

    public final BooleanPath controlaEstoque = createBoolean("controlaEstoque");

    public final DatePath<java.util.Date> dataExclusao = createDate("dataExclusao", java.util.Date.class);

    public final StringPath descricao = createString("descricao");

    public final StringPath descricaoConteudo = createString("descricaoConteudo");

    public final NumberPath<Long> idProduto = createNumber("idProduto", Long.class);

    public final BooleanPath produtoDestaque = createBoolean("produtoDestaque");

    public final BooleanPath produtoOferta = createBoolean("produtoOferta");

    public QProduto(String variable) {
        this(Produto.class, forVariable(variable), INITS);
    }

    public QProduto(Path<? extends Produto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduto(PathMetadata metadata, PathInits inits) {
        this(Produto.class, metadata, inits);
    }

    public QProduto(Class<? extends Produto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria"), inits.get("categoria")) : null;
    }

}

