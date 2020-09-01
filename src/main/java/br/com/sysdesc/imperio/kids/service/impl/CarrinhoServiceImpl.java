package br.com.sysdesc.imperio.kids.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CarrinhoCabecalhoDTO;
import br.com.sysdesc.imperio.kids.dto.CarrinhoDetalheDTO;
import br.com.sysdesc.imperio.kids.repository.CarrinhoCabecalhoRepository;
import br.com.sysdesc.imperio.kids.repository.domain.CarrinhoCabecalho;
import br.com.sysdesc.imperio.kids.repository.domain.CarrinhoDetalhe;
import br.com.sysdesc.imperio.kids.service.CarrinhoService;
import br.com.sysdesc.imperio.kids.util.DateUtil;
import br.com.sysdesc.imperio.kids.util.LongUtil;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	@Autowired
	private CarrinhoCabecalhoRepository carrinhoCabecalhoRepository;

	@Override
	public CarrinhoCabecalhoDTO gerarCarrinho(Long codigoCarrinho) {

		CarrinhoCabecalho carrinhoCabecalho = buscarOuCriarCarrinho(codigoCarrinho);

		return map(carrinhoCabecalho);
	}

	@Override
	public CarrinhoCabecalhoDTO incluirProduto(Long codigoCarrinho, CarrinhoDetalheDTO carrinhoDetalheDTO) {
		CarrinhoCabecalho carrinhoCabecalho = buscarOuCriarCarrinho(codigoCarrinho);

		inserirDetalhe(codigoCarrinho, carrinhoDetalheDTO, carrinhoCabecalho);

		carrinhoCabecalhoRepository.save(carrinhoCabecalho);

		return map(carrinhoCabecalho);
	}

	private void inserirDetalhe(Long codigoCarrinho, CarrinhoDetalheDTO carrinhoDetalheDTO, CarrinhoCabecalho carrinhoCabecalho) {

		Optional<CarrinhoDetalhe> optional = carrinhoCabecalho.getCarrinhoDetalhes().stream()
				.filter(detalhe -> detalhe.getCodigoProduto().equals(carrinhoDetalheDTO.getCodigoProduto())).findFirst();

		if (optional.isPresent()) {

			optional.get().setQuantidade(optional.get().getQuantidade().add(carrinhoDetalheDTO.getQuantidade()));

			return;
		}

		CarrinhoDetalhe carrinhoDetalhe = new CarrinhoDetalhe();
		carrinhoDetalhe.setCodigoCarrinhoCabecalho(codigoCarrinho);
		carrinhoDetalhe.setQuantidade(carrinhoDetalheDTO.getQuantidade());
		carrinhoDetalhe.setCodigoProduto(carrinhoDetalheDTO.getCodigoProduto());

		carrinhoCabecalho.getCarrinhoDetalhes().add(carrinhoDetalhe);
	}

	private CarrinhoCabecalho buscarOuCriarCarrinho(Long codigoCarrinho) {

		if (LongUtil.isNullOrZero(codigoCarrinho)) {

			return gerarCarrinho();
		}

		Optional<CarrinhoCabecalho> optional = carrinhoCabecalhoRepository.findById(codigoCarrinho);

		if (!optional.isPresent()) {

			return gerarCarrinho();
		}

		return optional.get();
	}

	private CarrinhoCabecalho gerarCarrinho() {

		CarrinhoCabecalho carrinhoCabecalho = new CarrinhoCabecalho();
		carrinhoCabecalho.setDataCadastro(DateUtil.getDateTimeNow());
		carrinhoCabecalho.setVendaefetuada(false);

		return carrinhoCabecalhoRepository.save(carrinhoCabecalho);
	}

	private CarrinhoCabecalhoDTO map(CarrinhoCabecalho carrinhoCabecalho) {

		CarrinhoCabecalhoDTO cabecalhoDTO = new CarrinhoCabecalhoDTO();
		cabecalhoDTO.setIdCarrinhoCabecalho(carrinhoCabecalho.getIdCarrinhoCabecalho());
		cabecalhoDTO.setQuantidade(
				carrinhoCabecalho.getCarrinhoDetalhes().stream().mapToLong(detalhe -> detalhe.getQuantidade().longValue()).sum());

		return cabecalhoDTO;
	}

}
