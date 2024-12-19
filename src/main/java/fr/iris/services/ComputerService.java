package fr.iris.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iris.dto.ComputerDto;
import fr.iris.model.ComputerModel;
import fr.iris.repository.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepository;

	public String count() {
		return "NB Computers : " + computerRepository.count();
	}

	public List<ComputerDto> getAll() {
		return computerRepository.findAll()
				.stream()
				.map(computer -> toDto(computer))
				.toList();
	}

	public ComputerDto createComputer(ComputerDto computerDto) {
		ComputerModel model = toModel(computerDto);
		ComputerModel outModel =  computerRepository.save(model);
		return toDto(outModel);
	}

	public ComputerDto updateComputer(ComputerDto computerDto, long id) {
		ComputerModel model = toModel(computerDto);
		ComputerModel outModel =  computerRepository.save(model);
		return toDto(outModel);
	}

	public boolean deleteComputer(long id) {
		try {
			computerRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private ComputerModel toModel(ComputerDto dto) {
		ComputerModel model = new ComputerModel();
		model.setBrand(dto.getBrand());
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setSerialNumber(dto.getSerialNumber());
		return model;
	}

	

	private ComputerDto toDto(ComputerModel model) {
		ComputerDto dto = new ComputerDto();
		dto.setBrand(model.getBrand());
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setSerialNumber(model.getSerialNumber());
		
		return dto;
	}	
	
	
	
}
