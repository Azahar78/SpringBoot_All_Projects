package com.citizen.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.citizen.entity.CitizenPlan;
import com.citizen.payload.SearchRequest;
import com.citizen.repo.CitizenRepository;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository repository;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repository.findDistinctPlanName();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repository.findDistinctPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan citizenPlan = new CitizenPlan();

		BeanUtils.copyProperties(request, citizenPlan, "planStartDate", "planEndDate");

		if (request.getPlanStartDate() != null) {
			try {
				LocalDate startDate = LocalDate.parse(request.getPlanStartDate(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				citizenPlan.setPlanStartDate(startDate);
			} catch (DateTimeParseException e) {
				// Handle parsing exception
				e.printStackTrace();
			}
		}

		if (request.getPlanEndDate() != null) {
			try {
				LocalDate endDate = LocalDate.parse(request.getPlanEndDate(),
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				citizenPlan.setPlanEndDate(endDate);
			} catch (DateTimeParseException e) {
				// Handle parsing exception
				e.printStackTrace();
			}
		}

		List<CitizenPlan> all = repository.findAll(Example.of(citizenPlan));

		return all;
	}

	@Override
	public Boolean downloadExcel(HttpServletResponse response) throws Exception {

		List<CitizenPlan> citizenList = repository.findAll();

		Workbook workbook = new HSSFWorkbook();

		Sheet sheet = workbook.createSheet("Citizen_Plan");
		Row rowheader = sheet.createRow(0);
		rowheader.createCell(0).setCellValue("Citizen_Id");
		rowheader.createCell(1).setCellValue("Citizen_Name");
		rowheader.createCell(2).setCellValue("Gender");
		rowheader.createCell(3).setCellValue("Plan_Name");
		rowheader.createCell(4).setCellValue("Plan_Status");
		rowheader.createCell(5).setCellValue("PlanStart_Date");
		rowheader.createCell(6).setCellValue("PlanEnd_Date");
		rowheader.createCell(7).setCellValue("Benefit_Amount");
		rowheader.createCell(8).setCellValue("Denial_Reason");
		rowheader.createCell(9).setCellValue("Terminated_Date");
		rowheader.createCell(10).setCellValue("Terminated_Reason");

		int count[] = { 1 };

		citizenList.forEach(c -> {

			Row rowData = sheet.createRow(count[0]);
			rowData.createCell(0).setCellValue(c.getCitizenId());
			rowData.createCell(1).setCellValue(c.getCitizenName());
			rowData.createCell(2).setCellValue(c.getGender());
			rowData.createCell(3).setCellValue(c.getPlanName());
			rowData.createCell(4).setCellValue(c.getPlanStatus());
            
		    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		    
		    rowData.createCell(5).setCellValue(c.getPlanStartDate() != null ? c.getPlanStartDate().format(pattern):"N/A");
			
		    rowData.createCell(6).setCellValue(c.getPlanEndDate() != null? c.getPlanEndDate().format(pattern):"N/A");
		    
		    rowData.createCell(7).setCellValue(c.getBenefitAmount()!=null ? String.valueOf(c.getBenefitAmount()) :"N/A");
		    
		    rowData.createCell(8).setCellValue(c.getDenialReason()!=null ? c.getDenialReason():"N/A");
		    
		    rowData.createCell(9).setCellValue(c.getTerminatedDate()!=null ? c.getTerminatedDate().format(pattern):"N/A");
		    
		    rowData.createCell(10).setCellValue(c.getTerminatedReason()!=null ? c.getTerminatedReason() :"N/A");
		    /*
		    
			if (c.getPlanStartDate() != null) {
				rowData.createCell(5).setCellValue(c.getPlanStartDate().format(pattern));
			} else {
				rowData.createCell(5).setCellValue("N/A");
			}

			if (c.getPlanEndDate() != null) {
				rowData.createCell(6).setCellValue(c.getPlanEndDate());
			} else {
				rowData.createCell(6).setCellValue("N/A");
			}

			if (c.getBenefitAmount() != null) {
				rowData.createCell(7).setCellValue(c.getBenefitAmount());
			} else {
				rowData.createCell(7).setCellValue("N/A");
			}

			if (c.getDenialReason() != null) {
				rowData.createCell(8).setCellValue(c.getDenialReason());
			} else {
				rowData.createCell(8).setCellValue("N/A");
			}

			if (c.getTerminatedDate() != null) {
				rowData.createCell(9).setCellValue(c.getTerminatedDate());
			} else {
				rowData.createCell(9).setCellValue("N/A");
			}

			if (c.getTerminatedReason() != null) {
				rowData.createCell(10).setCellValue(c.getTerminatedReason());
			} else {
				rowData.createCell(10).setCellValue("N/A");
			}
			
			*/

			count[0]++;

		});
        
		 //response.setContentType("application/vnd.ms-excel");
	//	response.setContentType("application/octet-stream");
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush(); 
		return true;
	}
	
	@Override
	public Boolean downloadPdf(HttpServletResponse response) throws Exception {
		
		Document document = new Document(PageSize.A4);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		PdfWriter.getInstance(document,response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Citizen Plan Table"));
		document.close();
		
		// outputStream.flush();
		
		return true;
	}

}
