package com.MegaDeals.repository;

import com.MegaDeals.entity.Image;
import com.MegaDeals.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
