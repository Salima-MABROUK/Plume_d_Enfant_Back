package com.poec.plumedenfant;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poec.plumedenfant.config.SecurityConfig;
import com.poec.plumedenfant.dao.model.Histoire;
import com.poec.plumedenfant.service.HistoireService;

//(classes=...)

@SpringBootTest
@AutoConfigureMockMvc
public class HistoireControlerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HistoireService histoireService;
	
   @Test
   @WithMockUser(roles = "MANAGER")
   @DisplayName("test get Histoire By Id")
   public void testgetHistoireById() throws Exception {
	   
	   Histoire histoire = new Histoire();
	   histoire.setId(1);
	   histoire.setCorps("Test 1");
	   
	   Optional<Histoire> optHistoire = Optional.of(histoire);
	   
	   when(histoireService.getHistoireById(1)).thenReturn(optHistoire);
	   
	   this.mockMvc.perform(get("/histoires/1")).andDo(print()).andExpect(status().isOk())
       .andExpect(content().string(containsString("{\"idHistoire\":Test 1}")));
	     	 
   }
   
   @Test
   @WithMockUser(roles = "MANAGER")
   @DisplayName("insert Histoire")
   public void testInsertHistoire() throws Exception {
	   
	   Histoire histoire = new Histoire();
	   histoire.setId(1);
	   histoire.setCorps("Test 1");
	      
	   this.mockMvc.perform( MockMvcRequestBuilders
			      .post("/histoires/creation")
			      .content(asJsonString(histoire))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().isCreated())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.Id").exists());
	   
   }
   
   @Test
   @WithMockUser(roles = "MANAGER")
   @DisplayName("test get Histoire By Id")
   public void testDeleteHistoireById() throws Exception {
	   
	   Histoire histoire = new Histoire();
	   histoire.setId(1);
	   histoire.setCorps("Test 1");
	   
	   this.mockMvc.perform(MockMvcRequestBuilders .delete("/histoires/1")).andDo(print()).andExpect(status().isOk());
       
	     	 
   }
   
   
   
   public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	

		
}
