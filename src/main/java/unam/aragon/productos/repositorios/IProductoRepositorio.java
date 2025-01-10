package unam.aragon.productos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unam.aragon.productos.entidades.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
    
    /** 
     * Obtiene todo los productos activos(true) o inactivos(false)
     * @param estaActivo de tipo boolean
     */
    @Query("SELECT p FROM Producto p where p.estaActivo = ?1")
    List<Producto> obtenerTodos(boolean estaActivo);

}
