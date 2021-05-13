package com.example.demo.controller;

import com.example.demo.model.Producto;
import java.util.List;

public interface DemoService {

    public List<Producto> allProductos();

    public Producto findById(Long id);

    public void save(Producto productoForm);

    public void delete(Long id);

    public void update(Producto productoForm);

}
