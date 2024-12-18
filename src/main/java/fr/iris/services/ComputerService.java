package fr.iris.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.iris.dto.ComputerDto;

@Service
public class ComputerService {
	private final Map<Long, ComputerDto> COMPUTERS = new HashMap<Long, ComputerDto>();
	private Long index = 0l;
	
	public String getHelloWorld() {
		return "NB Computers : " + COMPUTERS.size();
	}
	
	public ComputerDto createComputer(ComputerDto computerDto) {
		computerDto.setId(index);
		index++;
		return COMPUTERS.put(computerDto.getId(), computerDto);
	}
	
	public ComputerDto updateComputer(ComputerDto computerDto, long id) {
		computerDto.setId(id);
		return COMPUTERS.put(id, computerDto);
	}
	
	public ComputerDto deleteComputer( long id) {
		return COMPUTERS.remove(id);
	}
}
