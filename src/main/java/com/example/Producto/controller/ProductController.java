package com.example.Producto.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Producto.Service.ProductoService;
import com.example.Producto.persistance.model.Product;

import lombok.AllArgsConstructor;


@CrossOrigin    
@RestController  
@RequestMapping("/api/v1/products")  
@AllArgsConstructor
public class ProductController {

    ProductoService productoService;
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> response = 
        ResponseEntity.ok(productoService.getAllProducts());  
        return response;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        ResponseEntity<Product> response = ResponseEntity.ok(productoService.getProductsById(id));
        return response;
    }
    
    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
       ResponseEntity<Product> response = ResponseEntity.ok(productoService.addProduct(product));   

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct( @RequestBody Product product, @PathVariable Long id) {
        ResponseEntity<Product> response = ResponseEntity.ok(productoService.editProduct(product,id)); 
        return response;
    }

     @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable  Long id) {
        productoService.deleteProduct(id);
    }

    @PostMapping("/{productId}/buy/{userId}")
    public ResponseEntity<String> buyProduct(@PathVariable Long productId,@PathVariable Long userId) {
        productoService.buyProduct(userId, productId);
        return ResponseEntity.ok("Compra registrada exitosamente.");
    }
}
