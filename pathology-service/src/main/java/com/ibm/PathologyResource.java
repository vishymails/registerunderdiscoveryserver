package com.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Astama", "Warm water bath"),
			new Disease("D2", "HeadAche", "Hot water Vapour"),
			new Disease("D3", "Corona", "Wash Hands and stay home")
			);
	
	
	@RequestMapping("/diseases")
	public DiseaseList Diseases() {
		DiseaseList diseaseList = new DiseaseList();
		
		diseaseList.setDiseases(diseases);
		return diseaseList;
	}
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		Disease e = diseases.stream()
				.filter(disease -> Id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		
		return e;
	}
	
	
}
