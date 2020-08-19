package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPermissaoPrograma is a Querydsl query type for PermissaoPrograma
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPermissaoPrograma extends EntityPathBase<PermissaoPrograma> {

    private static final long serialVersionUID = 649919431L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPermissaoPrograma permissaoPrograma = new QPermissaoPrograma("permissaoPrograma");

    public final NumberPath<Long> codigoPerfil = createNumber("codigoPerfil", Long.class);

    public final NumberPath<Long> codigoPrograma = createNumber("codigoPrograma", Long.class);

    public final NumberPath<Long> codigoUsuario = createNumber("codigoUsuario", Long.class);

    public final BooleanPath flagCadastro = createBoolean("flagCadastro");

    public final BooleanPath flagExclusao = createBoolean("flagExclusao");

    public final BooleanPath flagLeitura = createBoolean("flagLeitura");

    public final NumberPath<Long> idPermissaoprograma = createNumber("idPermissaoprograma", Long.class);

    public final QPerfil perfil;

    public final QPrograma programa;

    public final QUsuario usuario;

    public QPermissaoPrograma(String variable) {
        this(PermissaoPrograma.class, forVariable(variable), INITS);
    }

    public QPermissaoPrograma(Path<? extends PermissaoPrograma> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPermissaoPrograma(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPermissaoPrograma(PathMetadata metadata, PathInits inits) {
        this(PermissaoPrograma.class, metadata, inits);
    }

    public QPermissaoPrograma(Class<? extends PermissaoPrograma> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.perfil = inits.isInitialized("perfil") ? new QPerfil(forProperty("perfil")) : null;
        this.programa = inits.isInitialized("programa") ? new QPrograma(forProperty("programa"), inits.get("programa")) : null;
        this.usuario = inits.isInitialized("usuario") ? new QUsuario(forProperty("usuario")) : null;
    }

}

