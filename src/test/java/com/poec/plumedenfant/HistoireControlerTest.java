package com.poec.plumedenfant;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

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
   public void testgetHistoireById() throws Exception {
	   
	   Histoire histoire = new Histoire();
	   histoire.setId(1);
	   histoire.setCorps("Test 1");

	   when(histoireService.getHistoireById(1)).thenReturn(histoire);
	   
	   this.mockMvc.perform(get("/histoires/1")).andDo(print()).andExpect(status().isOk())
       .andExpect(content().string(containsString("{\"idHistoire\":Test 1}")));
	     
	 
//	   Assert.assertEquals("Success",order.checkout(ppMock));
   }
		
}
