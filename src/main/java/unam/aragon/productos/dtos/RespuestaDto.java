package unam.aragon.productos.dtos;

import java.time.LocalDateTime;

public class RespuestaDto {
    private String Mensaje;
    private LocalDateTime Fecha;

    

    public RespuestaDto(String mensaje) {
        this.Mensaje = mensaje;
        this.Fecha = LocalDateTime.now();
    }

    public String getMensaje() {
        return Mensaje;
    }
    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
    public LocalDateTime getFecha() {
        return Fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }
    
}
