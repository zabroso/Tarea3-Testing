package test;

import org.junit.jupiter.api.*;

import src.Main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void restoreSystemIO() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    void crearClienteValido() {
        String input = String.join(System.lineSeparator(),
                "1",   
                "1",    
                "1",    
                "Juan", 
                "juan@mail.com",
                "5",    
                "4"     
        ) + System.lineSeparator();

        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        Main.run(scanner);
        scanner.close();

        String output = getOutput();

        assertTrue(output.contains("Cliente creado."));
    }

    @Test
    void crearClienteConCorreoInvalido() {
        String input = String.join(System.lineSeparator(),
                "1",        
                "1",      
                "2",        
                "Ana",      
                "correoSinArroba", 
                "5",        
                "4"         
        ) + System.lineSeparator();

        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        Main.run(scanner);
        scanner.close();

        String output = getOutput();

        assertTrue(output.contains("Error:"));
    }

    @Test
    void crearCompraYActualizarPuntos() {
        String input = String.join(System.lineSeparator(),
                "1", "1", "3", "Maria", "maria@mail.com", "5",  
                "2", "1", "1", "3", "100", "5",                  
                "3", "3",                                        
                "4"                                              
        ) + System.lineSeparator();

        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        Main.run(scanner);
        scanner.close();

        String output = getOutput();

        assertTrue(output.contains("Compra creada y puntos actualizados."));
        assertTrue(output.contains("Puntos: 100"));
        assertTrue(output.contains("Nivel: BRONCE"));
    }

    @Test
    void mostrarClienteNoExistente() {
        String input = String.join(System.lineSeparator(),
                "3",       
                "999",     
                "4"        
        ) + System.lineSeparator();

        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        Main.run(scanner);
        scanner.close();

        assertTrue(getOutput().contains("Cliente no encontrado."));
    }

    @Test
    void flujoEliminarClienteYCompras() {
        String input = String.join(System.lineSeparator(),
                "1", "1", "9", "Luis", "luis@mail.com", "5",    
                "2", "1", "22", "9", "50", "5",                 
                "1", "4", "9", "5",                             
                "2", "2", "5",                                  
                "4"                                             
        ) + System.lineSeparator();

        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        Main.run(scanner);
        scanner.close();

        String output = getOutput();

        assertTrue(output.contains("Cliente y sus compras eliminados."));
        assertTrue(output.contains("No hay compras registradas."));
    }
}
