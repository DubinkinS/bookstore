package org.example.service;

import org.example.domain.Shop;

import java.util.List;

public interface ShopService {
    void deleteShop(int id);

    Shop findShopById(int id);

    List<Shop> findAllShops();

    Shop saveShop(Shop shop);
}
