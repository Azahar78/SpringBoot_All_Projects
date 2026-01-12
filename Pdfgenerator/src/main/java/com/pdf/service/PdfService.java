package com.pdf.service;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;


@Service
public class PdfService {
	


	 public String generateAdmissionReceiptAndSave() {
	        try {
	            // Define the file path to save the PDF
	        	
	        	  UUID randomUUID = UUID.randomUUID();
	              
	              // Get the first 4 characters of the UUID string
	              String random = randomUUID.toString().substring(0, 6);
	        	
	            String filePath = "src/main/resources/static/"+random+"demo.pdf"; // Adjust path if needed

	            File file = new File(filePath);
	            file.getParentFile().mkdirs();

	            // Create PDF writer and document
	            PdfWriter writer = new PdfWriter(new FileOutputStream(file));
	            PdfDocument pdfDoc = new PdfDocument(writer);
	            Document document = new Document(pdfDoc);
	            
	            
	    
	               
	                    
	                    // Add Title
	                    document.add(new Paragraph("NEW LOKMANYA MEDICAL")
	                            .setFontSize(18).setBold());

	                    // Add Address
	                    document.add(new Paragraph("5HOP NO.3, SHREE TIRUMALA LUXURIA APT, SERENE MEADOWS, GANGAPUR RD."));
	                    document.add(new Paragraph("Mob: DINESH DEV 9503919686, 8010448846"));
	                    document.add(new Paragraph("Date: 20/10/2022").setMarginTop(10));

	                    // Add Patient Info
	                    document.add(new Paragraph("Patient : CASH SALE"));
	                    document.add(new Paragraph("Address: GURUJI HOSPITAL"));
	                    document.add(new Paragraph("Doctor: NASHIK").setMarginBottom(10));

	                    // Create Table
	                    Table table = new Table(new float[]{1, 1, 2, 1, 1, 1, 1, 1, 1});
	                    table.addHeaderCell("Sr");
	                    table.addHeaderCell("HSN Code");
	                    table.addHeaderCell("Description");
	                    table.addHeaderCell("Comp");
	                    table.addHeaderCell("Batch No.");
	                    table.addHeaderCell("Exp");
	                    table.addHeaderCell("Qty");
	                    table.addHeaderCell("M.R.P.");
	                    table.addHeaderCell("Amount");

	                    // Add Rows
	                    Object[][] data = {
	                            {1, "3004", "MOVEXX MR", "CIPLA L", "AFB21718", "11/23", 5, 100.00, 50.00},
	                            {2, "3004", "OMEE", "ALKEM L", "22281061", "03/24", 1, 61.87, 12.37},
	                            {3, "3004", "CEFIX 200", "CIPLA L", "TAAD1043A", "11/23", 4, 107.74, 43.10},
	                            {4, "3004", "LIMCEE 500", "ABBOT", "SAAJ1955", "01/23", 15, 23.05, 23.05},
	                            {5, "3004", "MACBERY DX SYRUP", "MACLEOD", "L001K1018", "11/23", 1, 87.00, 87.00},
	                            {6, "3004", "ALDIGESEIC -SP", "ALKEM L", "AST22103M8", "03/24", 10, 120.00, 120.00},
	                            {7, "3004", "GEMER 2", "SUN PHA", "SID7777A", "05/24", 15, 195.00, 195.00},
	                            {8, "3004", "GEMER 2", "SUN PHA", "SID1058A", "03/24", 15, 195.00, 195.00},
	                            {9, "3004", "RUGESIC OIL", "MEDISPI", "2203", "06/24", 1, 130.00, 130.00}
	                    };

	                    for (Object[] row : data) {
	                        for (Object cell : row) {
	                            table.addCell(cell.toString());
	                        }
	                    }

	                    document.add(table);

	                    // Add Gross and Net Amounts
	                    document.add(new Paragraph("GROSS: 855.52"));
	                    document.add(new Paragraph("LESS: 0.00"));
	                    document.add(new Paragraph("NET: 855.52").setBold().setFontSize(14).setMarginTop(10));
	                    document.add(new Paragraph("For NEW LOKMANYA MEDICAL").setMarginTop(20));
	                    document.add(new Paragraph("Pharmacists"));

	                    // Close Document
	                
	                
	            
	            
	            
	            // Close the document
	            document.close();

	         //   return filePath;
	            
	         

	            return filePath; // Return the file path for further use
	        } catch (Exception e) {
	            throw new RuntimeException("Error generating and saving PDF", e);
	        }
	    }
}








