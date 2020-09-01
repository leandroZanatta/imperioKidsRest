package br.com.sysdesc.imperio.kids.service;

import br.com.sysdesc.imperio.kids.dto.CarrinhoCabecalhoDTO;
import br.com.sysdesc.imperio.kids.dto.CarrinhoDetalheDTO;

public interface CarrinhoService {

	public abstract CarrinhoCabecalhoDTO gerarCarrinho(Long codigoCarrinho);

	public abstract CarrinhoCabecalhoDTO incluirProduto(Long codigoCarrinho, CarrinhoDetalheDTO carrinhoDetalheDTO);

}
