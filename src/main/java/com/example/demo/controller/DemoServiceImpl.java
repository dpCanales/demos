package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.modeloDAO.ProductoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    ProductoDAO productoDAO;

    @Override
    public List<Producto> allProductos() {
        return productoDAO.allProductos();
    }

    @Override
    public Producto findById(Long id) {
        return productoDAO.findProducto(id);
    }

    @Override
    public void save(Producto productoForm) {
        productoDAO.save(productoForm);
    }

    @Override
    public void delete(Long id) {
        productoDAO.delete(id);
    }

    @Override
    public void update(Producto productoForm) {
        Producto producto = new Producto();
        producto.setId(productoForm.getId());
        producto.setCantidad(productoForm.getCantidad());
        producto.setNombre(productoForm.getNombre());
        producto.setReutilizable(productoForm.getReutilizable());
        productoDAO.update(producto);
    }

}
