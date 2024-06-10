package com.example.sprint2.service;

import com.example.sprint2.dto.imp.ICartDto;
import com.example.sprint2.exp.BaseException;
import com.example.sprint2.model.Cart;
import com.example.sprint2.repository.ICartRepository;
import com.example.sprint2.service.imp.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;
    @Override
    public void addToCart(Long idProduct, Long idUser) {
        cartRepository.addToCart(idProduct,idUser);
    }

    @Override
    public List<Cart> findByProduct(Long idProduct,Long idUser) {
        return cartRepository.findByProduct(idProduct,idUser);
    }

    @Override
    public Cart getCartByIdProductAndIdUser(Long idProduct, Long idUser) {
        return cartRepository.getCartByIdProductAndIdUser(idProduct,idUser);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<ICartDto> listCart(Long idUser) {
        List<ICartDto> list;
        try {
            list = cartRepository.listCart(idUser);
        }catch (Exception e){
            throw new BaseException("Not List Product In Cart");
        }
        return list;
    }

    @Override
    public Long totalPrice(Long idUser) {
        Long count;
        try {
            count = cartRepository.totalPrice(idUser);
        }catch (Exception e){
            throw new BaseException("Not Total Price");
        }
        return count;
    }

    @Override
    public void paymentCart(Long idUser , String date) {
        cartRepository.paymentCart(idUser,date);
    }

    @Override
    public Long countCart(Long idUser) {
        Long count;
        try {
            count = cartRepository.countCart(idUser);
        }catch (Exception e){
            throw new BaseException("Not Count In Cart");
        }
        return count;
    }

    @Override
    public void deleteCart(Long idProduct, Long idUser) {
        cartRepository.deleteCart(idProduct,idUser);
    }

    @Override
    public Page<ICartDto> historyProduct(Pageable pageable, Long idUser) {
        return cartRepository.historyProduct(pageable, idUser);
    }

    @Override
    public Page<ICartDto> listOrderForAdmin(Pageable pageable) {
        Page<ICartDto> list;
        try {
            list = cartRepository.listOrderForAdmin(pageable);
        }catch (Exception e){
            throw new BaseException("Not List Order");
        }
        return list;
    }

    @Override
    public void confirmOrder(Long idUser, Timestamp createOrder) {
        cartRepository.confirmOrder(idUser, createOrder);
    }
}
