package models;


import java.sql.Timestamp;

public class Compra {
    private int id;
    private int idCliente;
    private int monto;
    private Timestamp fecha;

    public Compra(int id, int idCliente, int monto ,Timestamp fecha ){
        this.id = id;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getMonto() {
        return monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
