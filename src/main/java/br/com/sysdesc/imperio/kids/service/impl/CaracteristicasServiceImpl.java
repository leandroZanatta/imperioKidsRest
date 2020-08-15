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
import br.com.sysdesc.imperio.kids.util.DateUtil;
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

		return pagina.map(caracteristica -> {
			CaracteristicasDTO caracteristicasDTO = new CaracteristicasDTO();

			caracteristicasDTO.setIdCaracteristica(caracteristica.getIdCaracteristica());
			caracteristicasDTO.setDescricao(caracteristica.getDescricao());

			if (caracteristica.getDataExclusao() != null) {
				caracteristicasDTO.setDataExclusao(DateUtil.formatString(caracteristica.getDataExclusao(), DateUtil.FORMATO_DD_MM_YYYY));
			}

			return caracteristicasDTO;
		});
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

	@Override
	public void excluir(Long codigoCaracteristica) {
		Caracteristica caracteristica = buscarBuscaCaracteristica(codigoCaracteristica);

		caracteristica.setDataExclusao(DateUtil.getDateTimeNow());

		caracteristicasRepository.save(caracteristica);

	}

	@Override
	public void reincluir(Long codigoCaracteristica) {
		Caracteristica caracteristica = buscarBuscaCaracteristica(codigoCaracteristica);

		caracteristica.setDataExclusao(null);

		caracteristicasRepository.save(caracteristica);
	}

	private Caracteristica buscarBuscaCaracteristica(Long codigoCaracteristica) {

		return caracteristicasRepository.findById(codigoCaracteristica)
				.orElseThrow(() -> new SysDescException("Característica Não encontrada"));
	}
}
