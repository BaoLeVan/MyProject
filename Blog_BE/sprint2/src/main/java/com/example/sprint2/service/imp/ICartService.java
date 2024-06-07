package com.example.sprint2.service.imp;

import com.example.sprint2.dto.imp.ICartDto;
import com.example.sprint2.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

public interface ICartService {

    void addToCart(Long idProduct,Long idUser);
    List<Cart> findByProduct(Long idProduct,Long idUser);
    Cart getCartByIdProductAndIdUser(Long idProduct,Long idUser);
    void save(Cart cart);
    List<ICartDto> listCart(Long idUser);
    Long totalPrice(Long idUser);
    void paymentCart(Long idUser, String date);
    Long countCart(Long idUser);
    void deleteCart(Long idProduct,Long idUser);
    Page<ICartDto> historyProduct (Pageable pageable, Long idUser);
    Page<ICartDto> listOrderForAdmin(Pageable pageable);
    void confirmOrder ( Long idUser, Timestamp createOrder);
}
