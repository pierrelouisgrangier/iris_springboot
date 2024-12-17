package fr.iris.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iris.dto.ComputerDto;

@RestController()
@RequestMapping("iris")
public class DemoController {
	
	private final Map<Long, ComputerDto> COMPUTERS = new HashMap<Long, ComputerDto>();
	private Long index = 0l;
	
	@GetMapping()
	public String getHelloWorld() {
		return "NB Computers : " + COMPUTERS.size();
	}
	
	@PostMapping()
	public ComputerDto createComputer(@RequestBody ComputerDto computerDto) {
		computerDto.setId(index);
		index++;
		return COMPUTERS.put(computerDto.getId(), computerDto);
	}
	
	@PutMapping("{id}") 
	public ComputerDto updateComputer(@RequestBody ComputerDto computerDto, @PathVariable("id") long id) {
		computerDto.setId(id);
		return COMPUTERS.put(id, computerDto);
	}
	
	@DeleteMapping("{id}") 
	public ComputerDto deleteComputer( @PathVariable("id") long id) {
		return COMPUTERS.remove(id);
	}
	
	

}
