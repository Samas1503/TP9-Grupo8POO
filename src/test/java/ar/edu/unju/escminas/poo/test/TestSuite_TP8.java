package ar.edu.unju.escminas.poo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({ ComprasUtilTest.class, ArticulosUtilTest.class })
public class TestSuite_TP8 extends TestCase {

    @Override
    protected void setUp() throws Exception {
        System.out.println("inicia test");
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("finaliza el test");
        super.tearDown();
    }
}
