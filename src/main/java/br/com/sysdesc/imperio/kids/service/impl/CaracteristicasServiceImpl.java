package br.com.sysdesc.imperio.kids.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.sysdesc.imperio.kids.dto.CaracteristicasDTO;
import br.com.sysdesc.imperio.kids.repository.CaracteristicasRepository;
import br.com.sysdesc.imperio.kids.repository.domain.Caracteristica;
import br.com.sysdesc.imperio.kids.service.CaracteristicasService;
import br.com.sysdesc.imperio.kids.util.LongUtil;
import br.com.sysdesc.imperio.kids.util.StringUtil;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class CaracteristicasServiceImpl implements CaracteristicasService {

	@Autowired
	@Lazy
	private CaracteristicasRepository caracteristicasRepository;

	@Override
	public Page<CaracteristicasDTO> listar(String valorPesquisa, Long pagina, Long registros) {

		if (!StringUtil.isNullOrEmpty(valorPesquisa)) {

			return map(caracteristicasRepository.findByDescricaoLikeIgnoreCase(String.format("%%%s%%", valorPesquisa),
					PageRequest.of(pagina.intValue(), registros.intValue())));
		}

		return map(caracteristicasRepository.findAll(PageRequest.of(pagina.intValue(), registros.intValue())));
	}

	private Page<CaracteristicasDTO> map(Page<Caracteristica> pagina) {

		return pagina.map(caracteristica -> new CaracteristicasDTO(caracteristica.getIdCaracteristica(), caracteristica.getDescricao()));
	}

	@Override
	public void salvar(CaracteristicasDTO caracteristicasDTO) {

		if (LongUtil.isNullOrZero(caracteristicasDTO.getIdCaracteristica())) {

			if (StringUtil.isNullOrEmpty(caracteristicasDTO.getDescricao())) {
				throw new SysDescException("O campo descrição não pode ser vazio");
			}

			if (caracteristicasRepository.existsByDescricao(caracteristicasDTO.getDescricao())) {
				throw new SysDescException("Característica já está cadastrada, favor insira outra descrição");
			}
		}

		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setDescricao(caracteristicasDTO.getDescricao());
		caracteristica.setIdCaracteristica(caracteristicasDTO.getIdCaracteristica());

		caracteristicasRepository.save(caracteristica);

	}

}
