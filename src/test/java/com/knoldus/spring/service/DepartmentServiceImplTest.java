package com.knoldus.spring.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.knoldus.spring.Repository.DepartmentRepository;
import com.knoldus.spring.entity.Department;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DepartmentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DepartmentServiceImplTest {
    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    /**
     * Method under test: {@link DepartmentServiceImpl#saveDepartment(Department)}
     */
    @Test
    void testSaveDepartment() {
        Department department = new Department();
        department.setDepartmentAddress("42  St");
        department.setDepartmentCode("Code B2");
        department.setDepartmentId(103L);
        department.setDepartmentName(" Finance");
        when(departmentRepository.save((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("44  St");
        department1.setDepartmentCode("Code C1");
        department1.setDepartmentId(113L);
        department1.setDepartmentName("Management");
        assertSame(department, departmentServiceImpl.saveDepartment(department1));
        verify(departmentRepository).save((Department) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#fetchDepartmentList()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFetchDepartmentList() {
        // TODO: Complete this test.

        (new DepartmentServiceImpl()).fetchDepartmentList();
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment() {
        Department department = new Department();
        department.setDepartmentAddress("40 Main St");
        department.setDepartmentCode("Department123");
        department.setDepartmentId(103L);
        department.setDepartmentName("Department Java");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("41 Main St");
        department1.setDepartmentCode("Department456");
        department1.setDepartmentId(113L);
        department1.setDepartmentName("Department Agile");
        when(departmentRepository.save((Department) any())).thenReturn(department1);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);

        Department department2 = new Department();
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("Department321");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department DevOps");
        assertSame(department1, departmentServiceImpl.updateDepartment(department2, 123L));
        verify(departmentRepository).save((Department) any());
        verify(departmentRepository).findById((Long) any());
    }


    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment3() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main Street");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main Street");
        department1.setDepartmentCode("CS-102");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Java-Studio");
        when(departmentRepository.save((Department) any())).thenReturn(department1);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("");
        when(department2.getDepartmentCode()).thenReturn("CS-102");
        when(department2.getDepartmentName()).thenReturn("Java-Studio");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 Main Street");
        department2.setDepartmentCode("CS-102");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Java-Studio");
        assertSame(department1, departmentServiceImpl.updateDepartment(department2, 123L));
        verify(departmentRepository).save((Department) any());
        verify(departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment4() {
        Department department = new Department();
        department.setDepartmentAddress("Ds/1 St");
        department.setDepartmentCode("5652 Code");
        department.setDepartmentId(113L);
        department.setDepartmentName("Food & Sales Department ");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("DS/11/A St");
        department1.setDepartmentCode("3221 Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName(" Account ");
        when(departmentRepository.save((Department) any())).thenReturn(department1);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("42 Ds/11/B");
        when(department2.getDepartmentCode()).thenReturn("C3201");
        when(department2.getDepartmentName()).thenReturn("Department Fun ");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 AS/3/Q");
        department2.setDepartmentCode("D45621");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Joy");
        assertSame(department1, departmentServiceImpl.updateDepartment(department2, 123L));
        verify(departmentRepository).save((Department) any());
        verify(departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#updateDepartment(Department, Long)}
     */
    @Test
    void testUpdateDepartment5() {
        Department department = new Department();
        department.setDepartmentAddress("42 St");
        department.setDepartmentCode("565214 Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Coding Department ");
        Optional<Department> ofResult = Optional.of(department);

        Department department1 = new Department();
        department1.setDepartmentAddress("49  St");
        department1.setDepartmentCode("521420 Code");
        department1.setDepartmentId(133L);
        department1.setDepartmentName("Graph Department");
        when(departmentRepository.save((Department) any())).thenReturn(department1);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);
        Department department2 = mock(Department.class);
        when(department2.getDepartmentAddress()).thenReturn("48 Main ");
        when(department2.getDepartmentCode()).thenReturn("Department Fun");
        when(department2.getDepartmentName()).thenReturn("");
        doNothing().when(department2).setDepartmentAddress((String) any());
        doNothing().when(department2).setDepartmentCode((String) any());
        doNothing().when(department2).setDepartmentId((Long) any());
        doNothing().when(department2).setDepartmentName((String) any());
        department2.setDepartmentAddress("42 Main St");
        department2.setDepartmentCode("D56521");
        department2.setDepartmentId(123L);
        department2.setDepartmentName("Department Bath");
        assertSame(department1, departmentServiceImpl.updateDepartment(department2, 123L));
        verify(departmentRepository).save((Department) any());
        verify(departmentRepository).findById((Long) any());
        verify(department2, atLeast(1)).getDepartmentAddress();
        verify(department2, atLeast(1)).getDepartmentCode();
        verify(department2, atLeast(1)).getDepartmentName();
        verify(department2).setDepartmentAddress((String) any());
        verify(department2).setDepartmentCode((String) any());
        verify(department2).setDepartmentId((Long) any());
        verify(department2).setDepartmentName((String) any());
    }

    /**
     * Method under test: {@link DepartmentServiceImpl#deleteDepartmentById(Long)}
     */
    @Test
    void testDeleteDepartmentById() {
        doNothing().when(departmentRepository).deleteById((Long) any());
        departmentServiceImpl.deleteDepartmentById(123L);
        verify(departmentRepository).deleteById((Long) any());
    }
}

