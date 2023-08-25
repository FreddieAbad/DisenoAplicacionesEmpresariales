package corp.apps.salud.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import corp.apps.salud.exception.ResourceNotFoundException;
import corp.apps.salud.model.Employee;
import corp.apps.salud.repository.EmployeeRepository;



@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {
	
	private EmployeeRepository repository;

	@Autowired
	public EmployeeController(EmployeeRepository repository) {
		
		this.repository = repository;
	}
	
	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}

	
	@GetMapping("/findall")
	  public ResponseEntity<Iterable<Employee>> findAll(){
		  return ResponseEntity.ok(repository.findAll());
	  }

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable long id) {
		Optional<Employee> employee = Optional.of(repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee with ID :"+id+" Not Found!")));

		return ResponseEntity.ok().body(employee);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		Optional<Employee> employeeOptional = repository.findById(id);

		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			repository.delete(employee);
			return ResponseEntity.ok("Employee with ID " + id + " deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	  
	  @RequestMapping(value="/create", method = {RequestMethod.POST, RequestMethod.PUT})
	  public ResponseEntity<?> create(@Valid @RequestBody Employee employee,
				Errors errors/*, @RequestHeader String Authorization*/) throws Exception{
		  
			Employee result = repository.save(employee);
			
			URI location = 
					ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
							result.getId()).toUri();
			return ResponseEntity.created(location).build();
		  
	  }
	
	  
	

}
