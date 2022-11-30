package com.knoldus.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DepartmentTest {
    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Department()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Department department = new Department();

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("5652CER ");
        department1.setDepartmentId(113L);
        department1.setDepartmentName("Department Java");
        assertTrue(department.canEqual(department1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#setDepartmentAddress(String)}
     *   <li>{@link Department#setDepartmentCode(String)}
     *   <li>{@link Department#setDepartmentId(Long)}
     *   <li>{@link Department#setDepartmentName(String)}

     * </ul>
     */
    @Test
    void testConstructor() {
        Department actualDepartment = new Department();
        actualDepartment.setDepartmentAddress("40  St");
        actualDepartment.setDepartmentCode("56BP21 Code");
        actualDepartment.setDepartmentId(131L);
        actualDepartment.setDepartmentName("Department Management");
        String actualToStringResult = actualDepartment.toString();
        assertEquals("40  St", actualDepartment.getDepartmentAddress());
        assertEquals("56BP21 Code", actualDepartment.getDepartmentCode());
        assertEquals(131L, actualDepartment.getDepartmentId().longValue());
        assertEquals("Department Management", actualDepartment.getDepartmentName());
        assertEquals(
                "Department(departmentId=131," +
                        " departmentName=Department Management," +
                        " departmentAddress=40  St, " +
                        "departmentCode" + "=56BP21 Code)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#setDepartmentAddress(String)}
     *   <li>{@link Department#setDepartmentCode(String)}
     *   <li>{@link Department#setDepartmentId(Long)}
     *   <li>{@link Department#setDepartmentName(String)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Department actualDepartment = new Department(130L, "Commerce", "42  St", " AS3 Code");
        actualDepartment.setDepartmentAddress("42  St");
        actualDepartment.setDepartmentCode("AS3 Code");
        actualDepartment.setDepartmentId(130L);
        actualDepartment.setDepartmentName("Commerce");
        String actualToStringResult = actualDepartment.toString();
        assertEquals("42  St", actualDepartment.getDepartmentAddress());
        assertEquals("AS3 Code", actualDepartment.getDepartmentCode());
        assertEquals(130L, actualDepartment.getDepartmentId().longValue());
        assertEquals("Commerce", actualDepartment.getDepartmentName());
        assertEquals(
                "Department(departmentId=130, " +
                        "departmentName=Commerce, " +
                        "departmentAddress=42  St, " +
                        "departmentCode"
                        + "=AS3 Code)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");
        assertNotEquals(department, null);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals2() {
        Department department = new Department();
        department.setDepartmentAddress("42 STD ");
        department.setDepartmentCode("54367 Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Finance");
        assertNotEquals(department, "Agile Department");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Department department = new Department();
        department.setDepartmentAddress(" Main St");
        department.setDepartmentCode("DFG 56 Code");
        department.setDepartmentId(143L);
        department.setDepartmentName("Department Java");
        assertEquals(department, department);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Department department = new Department();
        department.setDepartmentAddress("42  St");
        department.setDepartmentCode("adghs63 Code");
        department.setDepartmentId(123L);
        department.setDepartmentName("gsfaf ");

        Department department1 = new Department();
        department1.setDepartmentAddress("42  St");
        department1.setDepartmentCode("adghs63 Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("gsfaf ");
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals5() {
        Department department = new Department();
        department.setDepartmentAddress("LOl ");
        department.setDepartmentCode("NTG ");
        department.setDepartmentId(113L);
        department.setDepartmentName("NOTHING Name");

        Department department1 = new Department();
        department1.setDepartmentAddress("LOL");
        department1.setDepartmentCode("NTG ");
        department1.setDepartmentId(113L);
        department1.setDepartmentName("NOTHING Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals6() {
        Department department = new Department();
        department.setDepartmentAddress(null);
        department.setDepartmentCode(" NEW Code");
        department.setDepartmentId(173L);
        department.setDepartmentName("NEW Name");

        Department department1 = new Department();
        department1.setDepartmentAddress(" Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals7() {
        Department department = new Department();
        department.setDepartmentAddress("56 St");
        department.setDepartmentCode("NO CODE");
        department.setDepartmentId(183L);
        department.setDepartmentName("DEP Name");

        Department department1 = new Department();
        department1.setDepartmentAddress("56 St");
        department1.setDepartmentCode("NO Code");
        department1.setDepartmentId(183L);
        department1.setDepartmentName("DEP Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals8() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode(null);
        department.setDepartmentId(123L);
        department.setDepartmentName("Department Name");

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals9() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main St");
        department.setDepartmentCode("Department Code");
        department.setDepartmentId(1L);
        department.setDepartmentName("Department Name");

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main St");
        department1.setDepartmentCode("Department Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals10() {
        Department department = new Department();
        department.setDepartmentAddress("42 Main ");
        department.setDepartmentCode("DF$4 Code");
        department.setDepartmentId(null);
        department.setDepartmentName("Department Python");

        Department department1 = new Department();
        department1.setDepartmentAddress("42 Main ");
        department1.setDepartmentCode("DF$4 Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department Python");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals11() {
        Department department = new Department();
        department.setDepartmentAddress(" Main St");
        department.setDepartmentCode("456 Code");
        department.setDepartmentId(103L);
        department.setDepartmentName("No St");

        Department department1 = new Department();
        department1.setDepartmentAddress(" Main St");
        department1.setDepartmentCode("456 Code");
        department1.setDepartmentId(123L);
        department1.setDepartmentName("Department");
        assertNotEquals(department, department1);
    }

}

