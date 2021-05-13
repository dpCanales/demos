package com.example.demo.modeloDAO;

import com.example.demo.model.Producto;
import java.util.List;

public interface ProductoDAO {

    public List<Producto> allProductos();

    public Producto findProducto(Long id);

    public int update(Producto producto);

    public int save(Producto producto);

    public int delete(Long id);

}
