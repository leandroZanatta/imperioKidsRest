package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerfil is a Querydsl query type for Perfil
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerfil extends EntityPathBase<Perfil> {

    private static final long serialVersionUID = 377926377L;

    public static final QPerfil perfil = new QPerfil("perfil");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> idPerfil = createNumber("idPerfil", Long.class);

    public final ListPath<PerfilUsuario, QPerfilUsuario> perfilUsuarios = this.<PerfilUsuario, QPerfilUsuario>createList("perfilUsuarios", PerfilUsuario.class, QPerfilUsuario.class, PathInits.DIRECT2);

    public final ListPath<PermissaoPrograma, QPermissaoPrograma> permissaoProgramas = this.<PermissaoPrograma, QPermissaoPrograma>createList("permissaoProgramas", PermissaoPrograma.class, QPermissaoPrograma.class, PathInits.DIRECT2);

    public QPerfil(String variable) {
        super(Perfil.class, forVariable(variable));
    }

    public QPerfil(Path<? extends Perfil> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerfil(PathMetadata metadata) {
        super(Perfil.class, metadata);
    }

}

