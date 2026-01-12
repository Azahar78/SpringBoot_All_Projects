package com.citizen;

import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.citizen.entity.CitizenPlan;

//@Component
public class AppRunner implements ApplicationRunner{

	//@Autowired
	//private CitizenRepository citizenRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		//citizenRepository.deleteAll();
		
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("willam");
		c1.setGender("Male");
		c1.setPlanName("Medical");
		c1.setPlanStatus("Active");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenefitAmount(6000.00);
        
    	CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("jenifer");
		c2.setGender("FeMale");
		c2.setPlanName("Food");
		c2.setPlanStatus("Denied");
       
       // c2.setPlanEndDate(LocalDate.now().plusMonths(6));
       // c2.setBenefitAmount(5000.00);
        c2.setDenialReason("Denied due insufficent balance..");
        

        
        CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Raja");
		c3.setGender("Male");
		c3.setPlanName("Food");
		c3.setPlanStatus("Active");
        c3.setPlanStartDate(LocalDate.now());
        c3.setPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setBenefitAmount(4000.00);
        
        
        CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Smith");
		c4.setGender("Male");
		c4.setPlanName("Medical");
		c4.setPlanStatus("Denied");
		 c4.setDenialReason("Not Eligible for insurace ..");
        
		//citizenRepository.saveAll(List.of(c1,c2,c3,c4));
	}

}
