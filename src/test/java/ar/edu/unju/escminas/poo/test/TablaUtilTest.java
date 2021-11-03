package ar.edu.unju.escminas.poo.test;

import org.junit.Test;

import ar.edu.unju.escminas.poo.util.TablaArticulosUtil;
import ar.edu.unju.escminas.poo.util.TablaClientesUtil;
import junit.framework.TestCase;

public class TablaUtilTest extends TestCase {
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

    @Test
    public void testCargaClientes() {
        assertNotNull(TablaClientesUtil.cargarClientes());
    }

    @Test
    public void testCargarArticulos() {
        assertNotNull(TablaArticulosUtil.cargarArticulos());
    }
}