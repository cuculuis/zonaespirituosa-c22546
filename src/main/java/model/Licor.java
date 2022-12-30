package model;

public class Licor {
    
    private int idlicor;
    private String tipo;
    private String marca;
    private double precio;
    private int stock;

    public Licor(int idlicor, String tipo, String marca, double precio, int stock) {
        this.idlicor = idlicor;
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public Licor(String tipo, String marca, double precio, int stock) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public Licor() {
    }

    public int getIdlicor() {
        return idlicor;
    }

    public void setIdlicor(int idlicor) {
        this.idlicor = idlicor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Licor{" + "idlicor=" + idlicor + ", tipo=" + tipo + ", marca=" + marca + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
    
}
