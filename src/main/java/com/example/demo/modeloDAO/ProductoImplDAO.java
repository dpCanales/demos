package com.example.demo.modeloDAO;

import com.example.demo.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoImplDAO implements ProductoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> allProductos() {
        String sql = "select * from producto";
        List<Producto> productos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Producto>(Producto.class));
        return productos;
    }

    @Override
    public Producto findProducto(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Producto producto) {
        String sql = "update producto set nombre = ? , cantidad = ? , reutilizable = ? , estado=? where id = ?";
        int res = jdbcTemplate.update(sql, producto.getNombre(), producto.getCantidad(), producto.getReutilizable(), "INA", producto.getId());
        return res;
    }

    @Override
    public int save(Producto producto) {
        String sql = "insert into producto(nombre, cantidad, reutilizable) values(?,?,?,?)";
        int res = jdbcTemplate.update(sql, producto.getNombre(), producto.getCantidad(), producto.getReutilizable(), "ACT");
        return res;
    }

    @Override
    public int delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
