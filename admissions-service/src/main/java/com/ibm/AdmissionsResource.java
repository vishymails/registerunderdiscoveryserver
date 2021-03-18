package com.ibm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	List<Patient> patients = Arrays.asList(
			new Patient("P1", "Karan", "Indian"),
			new Patient("P2", "George", "Singaporian"),
			new Patient("P3", "Manpreet", "Canadian")
			);
	
	
	@RequestMapping ("/patients")
	public List<Patient> patients() {
		return patients;
	}
	
	
	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable("Id") String Id) {
		Patient e = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		
		return e;
	}
	
	
	
	@RequestMapping("/physicians")
	public EmployeeList getPhysicians( ) {
		EmployeeList physicians = restTemplate.getForObject("http://localhost:8082/hr/employees", EmployeeList.class);
		return physicians;
	}
	
	

	@RequestMapping("/diseases")
	public DiseaseList getDiseases( ) {
		DiseaseList diseases = restTemplate.getForObject("http://localhost:8083/pathology/diseases", DiseaseList.class);
		return diseases;
	}
	
}
