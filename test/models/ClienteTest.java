package test.models;

import models.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void setCorreoValido() {
        Cliente cliente = new Cliente(1, "Juan", "juan@mail.com", 0, null, 0);
        assertDoesNotThrow(() -> cliente.setCorreo("nuevo@mail.com"));
        assertEquals("nuevo@mail.com", cliente.getCorreo());
    }

    @Test
    void setCorreoNuloLanzaExcepcion() {
        Cliente cliente = new Cliente(1, "Juan", "juan@mail.com", 0, null, 0);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setCorreo(null);
        });
        assertEquals("Correo inválido: debe contener '@'", thrown.getMessage());
    }

    @Test
    void setCorreoSinArrobaLanzaExcepcion() {
        Cliente cliente = new Cliente(1, "Juan", "juan@mail.com", 0, null, 0);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setCorreo("correo_invalido");
        });
        assertEquals("Correo inválido: debe contener '@'", thrown.getMessage());
    }
}
