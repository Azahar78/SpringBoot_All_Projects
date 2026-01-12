package com.citizen;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		
		for(int i =0;i<100;i++) {
		
			String password = generatePassword(6);
		    System.out.println(" Password : "+password);	
		}
		
		
	    
	}

	
	public String generatePassword(int length) {
		
	//	SecureRandom random = new SecureRandom();
		
		Random random = new Random();
		StringBuilder password = new StringBuilder(length);
		
		for(int i =0;i<length;i++) {
			
			int digit = random.nextInt(10);
			
			password.append(digit);
		}
		
		return password.toString();
	}
}

/*
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedDatabaseProcessor {
    private static final int NUMBER_OF_RECORDS = 1000; // Total number of records
    private static final int THREAD_POOL_SIZE = 10; // Number of threads in the pool

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
            final int recordId = i; // Need to be final or effectively final
            executor.submit(() -> processRecord(recordId));
        }

        executor.shutdown(); // Initiates an orderly shutdown
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish
        }

        System.out.println("All records processed.");
    }

    private static void processRecord(int recordId) {
        // Simulate processing of the record
        System.out.println("Processing record ID: " + recordId);
        try {
            Thread.sleep(100); // Simulate time taken to process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
*/


