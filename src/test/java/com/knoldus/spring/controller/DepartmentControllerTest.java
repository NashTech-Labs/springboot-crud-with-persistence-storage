package com.knoldus.spring.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.spring.entity.Department;
import com.knoldus.spring.service.DepartmentService;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DepartmentController.class})
@ExtendWith(SpringExtension.class)
class DepartmentControllerTest {
    @Autowired
    private DepartmentController departmentController;

    @MockBean
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentController#saveDepartment(Department)}
     */
    @Test
    void testSaveDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentAddress("Main St");
        department.setDepartmentCode("SEC Code");
        department.setDepartmentId(103L);
        department.setDepartmentName("Department Agile");
        when(departmentService.saveDepartment((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42  St");
        department1.setDepartmentCode("DEC Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Finance");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"departmentId\":103," +
                                        "\"departmentName\":\"Department Agile\"," +
                                        "\"departmentAddress\":\"Main St\"," +
                                        "\"departmentCode" + "\":\"SEC Code\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#fetchDepartmentList()}
     */
    @Test
    void testFetchDepartmentList() throws Exception {
        when(departmentService.fetchDepartmentList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#fetchDepartmentList()}
     */
    @Test
    void testFetchDepartmentList2() throws Exception {
        when(departmentService.fetchDepartmentList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/departments");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentAddress("42  St");
        department.setDepartmentCode("Ab7 Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Child Care");
        when(departmentService.updateDepartment((Department) any(), (Long) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("62 Main ");
        department1.setDepartmentCode("DS123 ");
        department1.setDepartmentId(133L);
        department1.setDepartmentName("Department Agile");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/departments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"departmentId\":123," +
                                        "\"departmentName\":\"Department Child Care\"," +
                                        "\"departmentAddress\":\"42  St\"," +
                                        "\"departmentCode" + "\":\"Ab7 Code\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById() throws Exception {
        doNothing().when(departmentService).deleteDepartmentById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/departments/{id}", 123L);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"));
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById2() throws Exception {
        doNothing().when(departmentService).deleteDepartmentById((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/departments/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"));
    }
}

