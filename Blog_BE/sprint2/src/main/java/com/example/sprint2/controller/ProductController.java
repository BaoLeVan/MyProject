package com.example.sprint2.controller;

import com.example.sprint2.dto.imp.IBlogDto;
import com.example.sprint2.dto.imp.NewIProductDto;
import com.example.sprint2.model.Product;
import com.example.sprint2.model.TypeProduct;
import com.example.sprint2.service.imp.IBlogService;
import com.example.sprint2.service.imp.IProductService;
import com.example.sprint2.service.imp.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping
    public ResponseEntity<?> getListProduct(@RequestParam(name = "page",defaultValue = "0") int page,
                                            @RequestParam(name = "idType",defaultValue = "0") Long idType){
        Pageable pageable = PageRequest.of(page,8);
        if (idType == 0){
            return new ResponseEntity<>(productService.listAllProduct(pageable),HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.listProduct(pageable,idType),HttpStatus.OK);
    }

    @GetMapping("/detailProduct/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/related")
    public ResponseEntity<?> listRelated(){
        return new ResponseEntity<>( productService.listRelated(),HttpStatus.OK);
    }

    @GetMapping("/forProduct")
    public ResponseEntity<?> getListProduct(){
        return new ResponseEntity<>(blogService.listBlogForProduct(),HttpStatus.OK);
    }

    @GetMapping("/typeProduct")
    public ResponseEntity<?> getListTypeProduct(){
        return new ResponseEntity<>(typeProductService.getAllByTypeProduct(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductByOptional(@PathVariable Long id){
        return new ResponseEntity<>(productService.getIdForProduct(id),HttpStatus.OK);
    }

}
