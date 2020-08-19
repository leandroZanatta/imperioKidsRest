package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerfilUsuario is a Querydsl query type for PerfilUsuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerfilUsuario extends EntityPathBase<PerfilUsuario> {

    private static final long serialVersionUID = 523005957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerfilUsuario perfilUsuario = new QPerfilUsuario("perfilUsuario");

    public final br.com.sysdesc.imperio.kids.repository.domain.pk.QPerfilUsuarioPk id;

    public final QPerfil perfil;

    public final QUsuario usuario;

    public QPerfilUsuario(String variable) {
        this(PerfilUsuario.class, forVariable(variable), INITS);
    }

    public QPerfilUsuario(Path<? extends PerfilUsuario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerfilUsuario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerfilUsuario(PathMetadata metadata, PathInits inits) {
        this(PerfilUsuario.class, metadata, inits);
    }

    public QPerfilUsuario(Class<? extends PerfilUsuario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new br.com.sysdesc.imperio.kids.repository.domain.pk.QPerfilUsuarioPk(forProperty("id")) : null;
        this.perfil = inits.isInitialized("perfil") ? new QPerfil(forProperty("perfil")) : null;
        this.usuario = inits.isInitialized("usuario") ? new QUsuario(forProperty("usuario")) : null;
    }

}

