package com.citizen.service;

import java.util.List;

import com.citizen.entity.CitizenPlan;
import com.citizen.payload.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService {

	List<String> getPlanNames();
	List<String>getPlanStatus();
	
	List<CitizenPlan> search(SearchRequest request);
	
	Boolean downloadExcel(HttpServletResponse response) throws Exception;
	
	Boolean downloadPdf(HttpServletResponse response) throws Exception;
}
