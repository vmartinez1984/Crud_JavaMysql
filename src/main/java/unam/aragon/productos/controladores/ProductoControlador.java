package unam.aragon.productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import unam.aragon.productos.dtos.RespuestaDto;
import unam.aragon.productos.entidades.Producto;
import unam.aragon.productos.repositorios.IProductoRepositorio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/Productos")
public class ProductoControlador {
    @Autowired
    private IProductoRepositorio repositorio;
    
    /**
     * Obtener todos
     * Esto es hacer un Select * From Tabla
     * @return Lista de productos
     */
    @GetMapping("")
    public List<Producto> obtenerTodos() {
        List<Producto> productos;

        productos = repositorio.obtenerTodos(true);
        
        return productos;
    }
    
    /**
     * Crear registro
     * Insertar en la tabla
     * @param producto
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 Created
    public Producto addProducto(@RequestBody Producto producto) {
        //TODO: process POST request
        //System.out.println(producto);

        return repositorio.save(producto);
    }

    /**
     * Obtener por Id
     * Select * from Tabla WHERE id = ?
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Producto obtnerPorId(@PathVariable int id) {
        Producto producto;

        producto = repositorio.findById(id) 
        //.orElseThrow(()-> new RuntimeException("No se encontro"));
        .orElse(null);
        //System.out.println(producto);
        if(producto == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado");
            
        return producto;
    }
    
    /**
     * Actualiza el registro 
     * UPDATE Tabla SET nombre = ?, precio = ? WHERE id = ?
     * @param id
     * @param producto
     * @return
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto producto) {        
        Producto productoOrginal;

        productoOrginal = obtnerPorId(id);
        productoOrginal.setNombre(producto.getNombre());
        productoOrginal.setPrecio(producto.getPrecio());

        return repositorio.save(productoOrginal);
    }

    /**
     * Borrar registro
     * DELETE Tabla WHERE id = ?
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaDto> borrarProducto(@PathVariable int id){
        Producto producto;

        producto = obtnerPorId(id);
        producto.setEstaActivo(false);
        repositorio.save(producto);

        return new ResponseEntity<>(new RespuestaDto("Producto borrado"), HttpStatus.ACCEPTED);
    }

}