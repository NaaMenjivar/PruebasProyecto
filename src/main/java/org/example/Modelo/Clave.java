package org.example.Modelo;

public class Clave {
    private String claveActual;
    private String nuevaClave;

    // Constructor
    public Clave(String claveActual, String nuevaClave) {
        this.claveActual = claveActual;
        this.nuevaClave = nuevaClave;
    }

    // Métodos Getter
    public String getClaveActual() {
        return claveActual;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    // Métodos Setter
    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }
}
