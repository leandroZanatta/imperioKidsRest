package br.com.sysdesc.imperio.kids.repository.domain.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerfilUsuarioPk is a Querydsl query type for PerfilUsuarioPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPerfilUsuarioPk extends BeanPath<PerfilUsuarioPk> {

    private static final long serialVersionUID = 2133654727L;

    public static final QPerfilUsuarioPk perfilUsuarioPk = new QPerfilUsuarioPk("perfilUsuarioPk");

    public final NumberPath<Long> codigoPerfil = createNumber("codigoPerfil", Long.class);

    public final NumberPath<Long> codigoUsuario = createNumber("codigoUsuario", Long.class);

    public QPerfilUsuarioPk(String variable) {
        super(PerfilUsuarioPk.class, forVariable(variable));
    }

    public QPerfilUsuarioPk(Path<? extends PerfilUsuarioPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerfilUsuarioPk(PathMetadata metadata) {
        super(PerfilUsuarioPk.class, metadata);
    }

}

