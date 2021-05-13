package com.example.demo.controller;

import com.example.demo.bean.JsonResponse;
import com.example.demo.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public String greeting(Model model) {

        return "view/index";
    }

    @ResponseBody
    @GetMapping("posts")
    public JsonResponse posts() {

        JsonResponse response = new JsonResponse();
        response.setData(demoService.allProductos());
        response.setSuccess(true);
        return response;
    }

    @ResponseBody
    @GetMapping("posts/{id}")
    public Object posts(@PathVariable Long id) {
        JsonResponse response = new JsonResponse();
        response.setData(demoService.findById(id));
        response.setSuccess(true);
        return response;
    }

    @ResponseBody
    @PostMapping("posts")
    public JsonResponse save(@RequestBody Producto productoForm) {
        demoService.save(productoForm);
        JsonResponse response = new JsonResponse();
        response.setSuccess(true);
        response.setMessage("Registro exitoso");
        return response;
    }

    @ResponseBody
    @PutMapping("posts")
    public JsonResponse updatePut(@RequestBody Producto productoForm) {
        demoService.update(productoForm);
        JsonResponse response = new JsonResponse();
        response.setSuccess(true);
        response.setMessage("Actualización exitoso");
        return response;
    }

    @ResponseBody
    @PatchMapping("/posts/{id}")
    public Object updatePatch(@PathVariable Long id) {
        return demoService.findById(id);
    }

    @ResponseBody
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        demoService.delete(id);
    }

}
