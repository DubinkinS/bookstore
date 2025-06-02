package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Book;
import org.example.domain.Post;
import org.example.domain.Shop;
import org.example.domain.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Override
    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Shop findShopById(int id) {
        return shopRepository.findShopById(id);
    }

    @Override
    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }
}



