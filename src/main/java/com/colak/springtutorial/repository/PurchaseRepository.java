package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    List<Purchase> findByCustomerId(UUID customerId);
}
