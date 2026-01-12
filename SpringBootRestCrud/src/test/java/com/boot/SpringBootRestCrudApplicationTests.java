package com.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SpringBootRestCrudApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	String baseUrl ="http://localhost:8080/v1/api/user/";
	
	@Test
	@Disabled
	@Order(1)
	@DisplayName("Test for Save User")
	public void testPostUser() throws Exception {
		
		// 1. Create Mock Request
		
		MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders
                .post(baseUrl+"post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userName\" : \"Dummy Test\",\"userEmail\" : \"test@gmail.com\" ,\"userPhno\" : 10023444 }");
		
		// 2. Execute It and Read result( Request + Response + Exception)
		
		MvcResult result = mockMvc.perform(request).andReturn();
				
		// 3. Read response from result
		
		MockHttpServletResponse response = result.getResponse();
		
		// 4. Assert Result Using JUnint
		
		assertEquals(HttpStatus.CREATED.value(),response.getStatus());
		assertNotNull(response.getContentAsString());
		if(!response.getContentAsString().contains("Create")){
			fail("User Not Created..");
		}
		
		
	}
	/*
	@Test
	@DisplayName("Save User Short Code ")
	public void testPostUserShort() throws Exception {
		
		   //MvcResult andReturn =
				mockMvc.perform(post("http://localhost:8080/v1/api/user/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userName\" : \"Dummy Test\",\"userEmail\" : \"test@gmail.com\" ,\"userPhno\" : 10023444 }"))
		        .andExpect(status().isCreated());
		        //   .andReturn();
	}
	
	*/
	
	@Test
	@Order(3)
	@DisplayName(" Fetch All Users")
	@Disabled
	public void testfetchAllUsers() throws Exception{
		
		MvcResult result = mockMvc.perform(get(baseUrl+"all")).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertNotNull(response.getContentAsString());

		
	}
	
	@Test
	@Order(5)
	@DisplayName(" Get User By ID ")
	@Disabled
    public void testFetchUser() throws Exception {
    
    	MvcResult result = mockMvc.perform(get(baseUrl+"fetch/{id}",1)).andReturn();
    	
    	MockHttpServletResponse response = result.getResponse();
    	
    	
    	assertEquals(HttpStatus.OK.value(),response.getStatus());
    	assertNotNull(response.getContentAsString());
    	assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
    	
    }
	
	@Test
	@Order(9)
	@DisplayName(" Remove User By id ")
	@Disabled
	public void testRemoveUser() throws Exception {
		
		MvcResult result = mockMvc.perform(delete(baseUrl+"remove/{id}",14)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
    	assertEquals(HttpStatus.OK.value(),response.getStatus());
    	assertNotNull(response.getContentAsString());
    	
    	if(!response.getContentAsString().contains("Deleted")) {
    		fail(" User Not Deleted..");
    	}
	}

	
   	@Test
   	@Order(10)
   	@DisplayName(" Update User Test")
	public void testmodifyUser() throws Exception {
		
   		MvcResult result =
   				mockMvc.perform(put(baseUrl+"put").contentType(MediaType.APPLICATION_JSON)
   				.content("{\"userId\":15,\"userName\" : \"Dummy Updated Test\",\"userEmail\" : \"test123@gmail.com\" ,\"userPhno\" : 1344444 }")).andReturn();
   		
   		MockHttpServletResponse response = result.getResponse();
   		
   		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
   		assertNotNull(response.getContentAsString());
   		
   		if(!response.getContentAsString().contains("updated")){
   		
   			fail("User Not Updated..");
   		}
   		
   		
	}
	
	
}
