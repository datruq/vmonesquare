package com.onesquare.vmonesquare.web.app;

import com.onesquare.vmonesquare.domain.entity.VendorMachineResponseEntity;
import com.onesquare.vmonesquare.domain.usercase.VmonesquareAppUsercase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class VmonesquareAppControllerTest {

    private MockMvc mockMvc;

    private VendorMachineResponseEntity vendorMachineResponseEntity;

    @MockBean
    private VmonesquareAppUsercase vmonesquareAppUsercase;

    @InjectMocks
    private VmonesquareAppController vmonesquareAppController;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(vmonesquareAppController)
                .build();
    }

    @Test
    public void postVendorMachineTest() throws Exception{
        doReturn(setVendorMachineResponseEntity())
                .when(vmonesquareAppUsercase).getItemFromVendorMachine(Mockito.any());
        String json = String.format("{\"cents\": \"0.10\",\"bills\": \"1.0\", " +
                "\"totalAmount\": \"5.0\",\"vmItem\": { \"bills\": \"1.0\"}}");
        this.mockMvc.perform(post("/vm/postVendorMachine", vendorMachineResponseEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"productListMap\":{\"1\":{\"id\":1,\"productCode\":\"L5\",\"productName\":\"nuts\",\"productPrice\":2.5},\"2\":{\"id\":2,\"productCode\":\"L3\",\"productName\":\"chips\",\"productPrice\":4.5}},\"isProdutListPresent\":0,\"productPrice\":0.0,\"responseCode\":0,\"message\":\"ok\"}"));
                //.andExpect(content().string("{\"productPrice\":20.0,\"message\":\"Status OK\",\"responseCode\":" + "\"0}"));
        verify(vmonesquareAppUsercase, times(1)).getItemFromVendorMachine(Mockito.any());
        verifyNoMoreInteractions(vmonesquareAppUsercase);
    }

    private VendorMachineResponseEntity setVendorMachineResponseEntity(){
        vendorMachineResponseEntity = new VendorMachineResponseEntity();
        vendorMachineResponseEntity.setResponseCode(0);
        vendorMachineResponseEntity.setMessage("ok");
        return vendorMachineResponseEntity;
    }
}
