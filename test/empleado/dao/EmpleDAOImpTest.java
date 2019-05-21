/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado.dao;

import empleado.dominio.Empleado;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author miguelmondragon
 */
public class EmpleDAOImpTest {
    
    public EmpleDAOImpTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of leerEmpleados method, of class EmpleDAOImp.
     */
    @Test
    public void testLeerEmpleados() {
        System.out.println("leerEmpleados");
        EmpleDAOImp instance = new EmpleDAOImp();
        List<Empleado> expResult = null;
        List<Empleado> result = instance.leerEmpleados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadoPorCodigo method, of class EmpleDAOImp.
     */
    @Test
    public void testGetEmpleadoPorCodigo() {
        System.out.println("getEmpleadoPorCodigo");
        int codigo = 0;
        EmpleDAOImp instance = new EmpleDAOImp();
        Empleado expResult = null;
        Empleado result = instance.getEmpleadoPorCodigo(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEmpleado method, of class EmpleDAOImp.
     */
    @Test
    public void testActualizarEmpleado() {
        System.out.println("actualizarEmpleado");
        Empleado empleado = null;
        EmpleDAOImp instance = new EmpleDAOImp();
        boolean expResult = false;
        boolean result = instance.actualizarEmpleado(empleado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleados method, of class EmpleDAOImp.
     */
    @Test
    public void testGetEmpleados() {
        System.out.println("getEmpleados");
        EmpleDAOImp instance = new EmpleDAOImp();
        List<Empleado> expResult = null;
        List<Empleado> result = instance.getEmpleados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleados method, of class EmpleDAOImp.
     */
    @Test
    public void testSetEmpleados() {
        System.out.println("setEmpleados");
        List<Empleado> emple = null;
        EmpleDAOImp instance = new EmpleDAOImp();
        instance.setEmpleados(emple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class EmpleDAOImp.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        Empleado empleado = null;
        String passwordEmple = "";
        EmpleDAOImp instance = new EmpleDAOImp();
        instance.updatePassword(empleado, passwordEmple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribirEnDB method, of class EmpleDAOImp.
     */
    @Test
    public void testEscribirEnDB() {
        System.out.println("escribirEnDB");
        Empleado empleado = null;
        String emplePassword = "";
        EmpleDAOImp instance = new EmpleDAOImp();
        instance.escribirEnDB(empleado, emplePassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
