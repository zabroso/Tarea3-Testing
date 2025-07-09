package models;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private int puntos;
    private Nivel nivel;
    private int streakDias;

    public Cliente(int id, String nombre, String correo, int puntos, Nivel nivel, int streakDias) {
        this.id = id;
        this.nombre = nombre;
        this.setCorreo(correo);
        this.puntos = puntos;
        this.nivel = nivel;
        this.streakDias = streakDias;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getStreakDias() {
        return streakDias;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo inválido: debe contener '@'");
        }
        this.correo = correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setStreakDias(int streakDias) {
        this.streakDias = streakDias;
    }

}
