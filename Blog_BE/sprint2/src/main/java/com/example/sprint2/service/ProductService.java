package com.example.sprint2.service;

import com.example.sprint2.dto.imp.IProductDto;
import com.example.sprint2.dto.imp.NewIProductDto;
import com.example.sprint2.dto.ProductDto;
import com.example.sprint2.exp.BaseException;
import com.example.sprint2.model.Product;
import com.example.sprint2.repository.IProductRepository;
import com.example.sprint2.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> listProduct(Pageable pageable, Long idType) {
        Page<Product> list;
        try {
            list = productRepository.listProduct(pageable, idType);
        }catch (Exception e){
            throw new BaseException("Not Product");
        }
        return list;
    }

    @Override
    public Page<Product> listAllProduct(Pageable pageable) {
        Page<Product> list;
        try {
            list = productRepository.listAllProduct(pageable);
        }catch (Exception e){
            throw new BaseException("Not Product");
        }
        return list;
    }

    @Override
    public Product getProductById(Long id) {
        Product product ;
        try {
            product = productRepository.getProductById(id);
        }catch (Exception e) {
            throw new BaseException("Not Found Product");
        }
        return product;
    }

    @Override
    public List<Product> listRelated() {
        List<Product> list;
        try {
            list = productRepository.listRelated();
        }catch (Exception e){
            throw new BaseException("Not Relate Product");
        }
        return list;
    }

    @Override
    public Page<Product> manageProduct(Pageable pageable, String name) {
        Page<Product>  list;
        try {
            list = productRepository.manageProduct(pageable, "%" + name + "%");
        }catch (Exception e){
            throw new BaseException("Not List Product");
        }
        return list;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void createProduct(ProductDto product) {
        productRepository.createProduct(product);
    }

    @Override
    public Optional<NewIProductDto> getIdForProduct(Long idProduct) {
        Optional<NewIProductDto> product;
        try{
            product =  productRepository.getIdForProduct(idProduct);
        }catch (Exception e){
            throw new BaseException("Not Blog Current");
        }
        return product;
    }

    @Override
    public void updateProduct(ProductDto product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<IProductDto> getDetailsOrder(Long idUser, Timestamp createOrder) {
        List<IProductDto> list;
        try {
            list = productRepository.getDetailsOrder(idUser,createOrder);
        }catch (Exception e){
            throw new BaseException("Not Count In Cart");
        }
        return list;
    }

    @Override
    public List<IProductDto> getListProductForPayment(Long idUser, String createOrder) {
        return productRepository.getListProductForPayment(idUser,createOrder);
    }

    @Override
    public List<IProductDto> checkListProductInStock(Long idUser) {
        return productRepository.checkListProductInStock(idUser);
    }

}
