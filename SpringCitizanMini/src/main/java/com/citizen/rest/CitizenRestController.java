package com.citizen.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.entity.CitizenPlan;
import com.citizen.payload.SearchRequest;
import com.citizen.service.CitizenService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class CitizenRestController {

	@Autowired
	private CitizenService service;
	
	@GetMapping("/home")
	public ResponseEntity<String> welcome(){
		return ResponseEntity.ok("Welcome Citizen Api..");
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getAllPlanName(){
		
		List<String> planNames = service.getPlanNames();
		
		return ResponseEntity.ok(planNames);
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<String>> getAllPlanStatus(){
		
		List<String> planStatus = service.getPlanStatus();
		
		return ResponseEntity.ok(planStatus);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<CitizenPlan>> searchCitizen(@RequestBody SearchRequest request){
		
		List<CitizenPlan> search = service.search(request);
		
		return ResponseEntity.ok(search);
	}
	
	@GetMapping("/excel")
	public ResponseEntity<String> generateExcel(HttpServletResponse response){
		
		ResponseEntity<String> res = null;
		
		// response.setContentType("application/octet-stream");
	//	 response.setContentType("application/vnd.ms-excel");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=citizen_plan.xls"+UUID.randomUUID());
		
		try {
			Boolean isdownload = service.downloadExcel(response);
			
			res =ResponseEntity.ok("Excel File DownLoaded");
			
		} catch (Exception e) {
		   e.printStackTrace();
		   res =ResponseEntity.ok("Something Went Wrong...");
		   
		}
		
		return res;
	}
	
	@GetMapping("/pdf")
	public ResponseEntity<String> generatePdf(HttpServletResponse response){
		
		ResponseEntity<String> res = null;
		
	//	response.setContentType("application/pdf");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=citizen_plan.pdf");

		try {
			Boolean isdownload = service.downloadPdf(response);
			
			res =ResponseEntity.ok("pdf File DownLoaded");
			
		} catch (Exception e) {
		   e.printStackTrace();
		   res =ResponseEntity.ok("Something Went Wrong...");
		   
		}
		
		return res;
	}
}
