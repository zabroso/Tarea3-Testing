package models;


public enum Nivel {
    BRONCE(0, 499, 0),
    PLATA(500, 1499, 20),
    ORO(1500, 2999, 50),
    PLATINO(3000, Integer.MAX_VALUE, 100);

    private final int umbralMin;
    private final int umbralMax;
    private final int porcentajeBeneficio;

    Nivel(int umbralMin, int umbralMax, int porcentajeBeneficio) {
        this.umbralMin = umbralMin;
        this.umbralMax = umbralMax;
        this.porcentajeBeneficio = porcentajeBeneficio;
    }

    // Getters y setters
    public int getUmbralMin() {
        return umbralMin;
    }

    public int getUmbralMax() {
        return umbralMax;
    }

    public int getPorcentajeBeneficio() {
        return porcentajeBeneficio;
    }

    /**
     * Retorna el nivel correspondiente dado un puntaje total.
     */
    public static Nivel obtenerPorPuntaje(int puntos) {
        for (Nivel nivel : values()) {
            if (puntos >= nivel.umbralMin && puntos <= nivel.umbralMax) {
                return nivel;
            }
        }
        return BRONCE;
    }
}
