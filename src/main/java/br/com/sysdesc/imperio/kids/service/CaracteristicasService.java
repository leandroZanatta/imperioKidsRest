package br.com.sysdesc.imperio.kids.service;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;

public interface CaracteristicasService {

	public abstract Page<CaracteristicasDTO> listar(String valorPesquisa, Long pagina, Long registros);

	public abstract void salvar(CaracteristicasDTO caracteristicasDTO);

	public abstract void excluir(Long codigoCaracteristica);

	public abstract void reincluir(Long codigoCaracteristica);
}
