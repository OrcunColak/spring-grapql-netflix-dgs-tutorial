package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
