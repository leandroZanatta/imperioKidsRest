package br.com.sysdesc.imperio.kids.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;
import br.com.sysdesc.imperio.kids.repository.CaracteristicasRepository;
import br.com.sysdesc.imperio.kids.service.CaracteristicasService;

@Service
public class CaracteristicasServiceImpl implements CaracteristicasService {

	@Autowired
	@Lazy
	private CaracteristicasRepository caracteristicasRepository;

	@Override
	public Page<CaracteristicasDTO> listar() {

		return caracteristicasRepository.findAll(PageRequest.of(0, 90))
				.map(caracteristica -> new CaracteristicasDTO(caracteristica.getIdCaracteristica(), caracteristica.getDescricao()));
	}

}
