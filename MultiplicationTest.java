/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arshad
 */
public class MultiplicationTest {
    
    public MultiplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of exec method, of class Multiplication.
     */
    

    /**
     * Test of iMultiply method, of class Multiplication.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        int[][] Matrix_1 = {{1,1},{1,1}};
        int[][] Matrix_2 = {{1,1},{1,1}};
        int m = 2;
        int q = 2;
        int p = 2;
        Multiplication instance = new Multiplication();
        int[][] expResult = {{2,2},{2,2}};
        int[][] result = instance.iMultiply(Matrix_1, Matrix_2, m, q, p);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of populate method, of class Multiplication.
     */
    @Test
    public void testPopulate() {
        System.out.println("populate");
        int a = 2;
        int b = 2;
        int[][] z = {{1,1},{1,1}};
        Multiplication instance = new Multiplication();
        int[][] expResult = {{1,1},{1,1}};
        int[][] result = instance.populate(a, b, z);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Multiplication.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        int[][] A = {{2,2},{2,2}};
        int[][] B = {{1,1},{1,1}};
        Multiplication instance = new Multiplication();
        int[][] expResult = {{1,1},{1,1}};
        int[][] result = instance.sub(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Multiplication.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[][] A = {{1,1},{1,1}};
        int[][] B = {{1,1},{1,1}};
        Multiplication instance = new Multiplication();
        int[][] expResult = {{2,2},{2,2}};
        int[][] result = instance.add(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
