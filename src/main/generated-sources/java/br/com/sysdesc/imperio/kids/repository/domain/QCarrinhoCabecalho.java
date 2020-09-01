package br.com.sysdesc.imperio.kids.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarrinhoCabecalho is a Querydsl query type for CarrinhoCabecalho
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarrinhoCabecalho extends EntityPathBase<CarrinhoCabecalho> {

    private static final long serialVersionUID = -882949715L;

    public static final QCarrinhoCabecalho carrinhoCabecalho = new QCarrinhoCabecalho("carrinhoCabecalho");

    public final ListPath<CarrinhoDetalhe, QCarrinhoDetalhe> carrinhoDetalhes = this.<CarrinhoDetalhe, QCarrinhoDetalhe>createList("carrinhoDetalhes", CarrinhoDetalhe.class, QCarrinhoDetalhe.class, PathInits.DIRECT2);

    public final NumberPath<Long> codigoCliente = createNumber("codigoCliente", Long.class);

    public final DateTimePath<java.util.Date> dataCadastro = createDateTime("dataCadastro", java.util.Date.class);

    public final NumberPath<Long> idCarrinhoCabecalho = createNumber("idCarrinhoCabecalho", Long.class);

    public final BooleanPath vendaefetuada = createBoolean("vendaefetuada");

    public QCarrinhoCabecalho(String variable) {
        super(CarrinhoCabecalho.class, forVariable(variable));
    }

    public QCarrinhoCabecalho(Path<? extends CarrinhoCabecalho> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarrinhoCabecalho(PathMetadata metadata) {
        super(CarrinhoCabecalho.class, metadata);
    }

}

