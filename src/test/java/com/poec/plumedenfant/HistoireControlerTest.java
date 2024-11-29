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
import org.springframework.test.web.servlet.MockMvc;

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
   public void testgetHistoireById() throws Exception {

	   when(histoireService.getHistoireById(2)).thenReturn(new Histoire());
	   
	   this.mockMvc.perform(get("/histoires/2")).andDo(print()).andExpect(status().isOk())
       .andExpect(content().string(containsString("{\"id\":null,\"name\":null,\"price\":null,\"vat\":null,\"category\":null,\"supplier\":null}")));
	   
	 
	   //Assert.assertEquals("Success",order.checkout(ppMock));
   }
		
}
