package test.models;

import models.Nivel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NivelTest {

    @Test
    void obtenerNivelDentroDelRango() {
        assertEquals(Nivel.BRONCE, Nivel.obtenerPorPuntaje(0));
        assertEquals(Nivel.BRONCE, Nivel.obtenerPorPuntaje(50));
        assertEquals(Nivel.BRONCE, Nivel.obtenerPorPuntaje(499));

        assertEquals(Nivel.PLATA, Nivel.obtenerPorPuntaje(500));
        assertEquals(Nivel.PLATA, Nivel.obtenerPorPuntaje(700));
        assertEquals(Nivel.PLATA, Nivel.obtenerPorPuntaje(1499));

        assertEquals(Nivel.ORO, Nivel.obtenerPorPuntaje(1500));
        assertEquals(Nivel.ORO, Nivel.obtenerPorPuntaje(2000));
        assertEquals(Nivel.ORO, Nivel.obtenerPorPuntaje(2999));

        assertEquals(Nivel.PLATINO, Nivel.obtenerPorPuntaje(3000));
        assertEquals(Nivel.PLATINO, Nivel.obtenerPorPuntaje(3001));
    }

    @Test
    void obtenerNivelPorDebajoDeRangoDevuelveBronce() {
        assertEquals(Nivel.BRONCE, Nivel.obtenerPorPuntaje(-10));
    }
}
