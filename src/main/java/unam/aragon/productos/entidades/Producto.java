package unam.aragon.productos.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    private boolean estaActivo;
    private LocalDateTime fechaDeRegistro;    
    private String guid; // Propiedad tipo GUID   

    public Producto() { 
        this.guid = UUID.randomUUID().toString();        
        this.fechaDeRegistro = LocalDateTime.now();
        this.estaActivo = true;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.estaActivo = true;
        this.guid = UUID.randomUUID().toString();
        this.precio = precio;
        this.fechaDeRegistro = LocalDateTime.now();
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEstaActivo() {
        return estaActivo;
    }
    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
    public LocalDateTime getFechaDeRegistro() {
        return fechaDeRegistro;
    }
    public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
    
}
