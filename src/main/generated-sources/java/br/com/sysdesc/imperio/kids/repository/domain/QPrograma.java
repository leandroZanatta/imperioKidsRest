package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrograma is a Querydsl query type for Programa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrograma extends EntityPathBase<Programa> {

    private static final long serialVersionUID = 977938490L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrograma programa = new QPrograma("programa");

    public final StringPath descricao = createString("descricao");

    public final StringPath icone = createString("icone");

    public final NumberPath<Long> idPrograma = createNumber("idPrograma", Long.class);

    public final NumberPath<Long> ordem = createNumber("ordem", Long.class);

    public final ListPath<PermissaoPrograma, QPermissaoPrograma> permissaoProgramas = this.<PermissaoPrograma, QPermissaoPrograma>createList("permissaoProgramas", PermissaoPrograma.class, QPermissaoPrograma.class, PathInits.DIRECT2);

    public final QPrograma programaPai;

    public final ListPath<Programa, QPrograma> programas = this.<Programa, QPrograma>createList("programas", Programa.class, QPrograma.class, PathInits.DIRECT2);

    public QPrograma(String variable) {
        this(Programa.class, forVariable(variable), INITS);
    }

    public QPrograma(Path<? extends Programa> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrograma(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrograma(PathMetadata metadata, PathInits inits) {
        this(Programa.class, metadata, inits);
    }

    public QPrograma(Class<? extends Programa> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.programaPai = inits.isInitialized("programaPai") ? new QPrograma(forProperty("programaPai"), inits.get("programaPai")) : null;
    }

}

