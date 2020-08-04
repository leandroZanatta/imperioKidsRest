package br.com.sysdesc.imperio.kids.service;

import org.springframework.data.domain.Page;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;

@FunctionalInterface
public interface CaracteristicasService {

	public abstract Page<CaracteristicasDTO> listar();
}
