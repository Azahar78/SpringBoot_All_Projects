package com.pdf.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfRestController {

	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/done")
	public ResponseEntity<?> generate() {
		
		String admissionReceiptAndSave = pdfService.generateAdmissionReceiptAndSave();
		
		return ResponseEntity.ok(admissionReceiptAndSave);
	}
}
