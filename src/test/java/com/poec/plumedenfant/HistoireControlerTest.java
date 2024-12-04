package com.poec.plumedenfant;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
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

@SpringBootTest
@AutoConfigureMockMvc
public class HistoireControlerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HistoireService histoireService;
	
   @Test
   @WithMockUser(authorities = "ADMIN")
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
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("test get all Histoires")
   public void testgetHistoires() throws Exception {
	  
	   List<Histoire> list = new ArrayList<Histoire>();
	   
	   Histoire histoire1 = new Histoire();
	   histoire1.setId(1);
	   histoire1.setCorps("Test 1");
	   histoire1.setNbLike(1);
	   Histoire histoire2 = new Histoire();
	   histoire2.setId(2);
	   histoire2.setCorps("Test 2");
	   histoire2.setNbLike(2);
	   Histoire histoire3 = new Histoire();
	   histoire3.setId(3);
	   histoire3.setCorps("Test 3");
	   histoire3.setNbLike(3);
	   
	   list.add(histoire1);
	   list.add(histoire2);
	   list.add(histoire3);
	   
	   when(histoireService.getAllHistoireSortedByLike()).thenReturn(list);
	   
	   this.mockMvc.perform(get("/histoires")).andDo(print()).andExpect(status().isOk())
	   .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[0].corps").value("Test 1"))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[0].nbLike").value(1))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[1].corps").value("Test 2"))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[1].nbLike").value(2))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[2].corps").value("Test 3"))
	   .andExpect(MockMvcResultMatchers.jsonPath("$[2].nbLike").value(3));
   	   	 
   }
   
  
   @Test
   @WithMockUser(authorities = "USER")
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
		      .andExpect(status().isCreated());
	   
   }
   
   @Test
   @WithMockUser(authorities = "ADMIN")
   @DisplayName("update Histoire")
   public void testUpdateHistoire() throws Exception {
	   
	   Histoire histoire = new Histoire();
	   histoire.setId(1);
	   histoire.setCorps("Test 2");
	         
	   this.mockMvc.perform( MockMvcRequestBuilders
			      .patch("/histoires/modification/1")
			      .content(asJsonString(histoire))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk());
	   
   }
   
   @Test
   @WithMockUser( authorities = { "ADMIN" })
   @DisplayName("test delete Histoire By Id")
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
