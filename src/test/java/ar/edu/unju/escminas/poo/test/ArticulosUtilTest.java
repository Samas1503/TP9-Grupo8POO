package ar.edu.unju.escminas.poo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.util.ArticulosUtil;

public class ArticulosUtilTest {

    @Test
    public void verificarArticuloTest() {
        Articulo articulo = new Articulo("heladera", "hyundai", 1, 150000);
        Articulo articulo2 = new Articulo("licuadora", "liliana", 1, 20000);
        assertTrue(ArticulosUtil.verificarArticuloSeleccionado(articulo));
        assertFalse(ArticulosUtil.verificarArticuloSeleccionado(articulo2));
    }

}
