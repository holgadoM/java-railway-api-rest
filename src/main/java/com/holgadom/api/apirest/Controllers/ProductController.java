package com.holgadom.api.apirest.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holgadom.api.apirest.Entities.Product;
import com.holgadom.api.apirest.Repositories.ProductRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productoRepository;

    @GetMapping("/")
    public List<Product> getAll() {
        return this.productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@RequestParam Long id) {
        return this.productoRepository.findById( id )
            .orElseThrow( ()-> new RuntimeException("No se encontrol elproducto con el ID "+id) );
    }
    
    @PostMapping("/")
    public Product create(@RequestBody Product product) {

        return this.productoRepository.save( product );
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product _product = this.productoRepository.findById(id)
        .orElseThrow( ()-> new RuntimeException("No se encontrol elproducto con el ID "+id) );

        _product.setName(product.getName());
        _product.setPrice( product.getPrice() ) ;

        return this.productoRepository.save(_product);

    }

    @DeleteMapping("/{id}")
    public String deleteProduct( @PathVariable Long id ){
        Product _product = this.productoRepository.findById(id)
        .orElseThrow( ()-> new RuntimeException("No se encontrol elproducto con el ID "+id) );

        this.productoRepository.delete(_product);

        return "Producto eliminado correctamente";
    }


    


}
