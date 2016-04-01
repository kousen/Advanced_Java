package oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee fred = new Salaried();

    @Test
    public void getAndSetName() {
        assertEquals(Employee.DEFAULT_NAME, fred.getName());

        fred.setName("Name");
        assertEquals("Name", fred.getName());
    }

    @Test
    public void equalsAndHashCode() throws Exception {
        fred.setName("Fred");
        Employee fred1 = new Salaried("Fred");
        fred1.setId(fred.getId());
        assertTrue(fred.equals(fred1));
        assertEquals(fred.hashCode(), fred1.hashCode());
    }
}