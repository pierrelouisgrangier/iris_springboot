package fr.iris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iris.dto.ComputerDto;
import fr.iris.services.ComputerService;

@RestController()
@RequestMapping("iris")
public class DemoController {
	
	@Autowired
	private ComputerService computerService;

	
	@GetMapping()
	public String count() {
		return computerService.count();
	}
	

	@GetMapping("all")
	public List<ComputerDto> getAll() {
		return computerService.getAll();
	}
	
	@PostMapping()
	public ComputerDto createComputer(@RequestBody ComputerDto computerDto) {
		return computerService.createComputer(computerDto);
	}
	
	@PutMapping("{id}") 
	public ComputerDto updateComputer(@RequestBody ComputerDto computerDto, @PathVariable("id") long id) {
		return computerService.updateComputer(computerDto, id);
	}
	
	@DeleteMapping("{id}") 
	public void deleteComputer( @PathVariable("id") long id) {
		computerService.deleteComputer(id);
	}
	
	

}
