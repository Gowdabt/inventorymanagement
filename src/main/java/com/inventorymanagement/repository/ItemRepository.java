package com.inventorymanagement.repository;

import com.inventorymanagement.model.Item;
import com.inventorymanagement.model.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemStatusAndItemEnteredByUser(ItemStatus itemStatus, String itemEnteredByUser);

    boolean deleteById(int itemId);

    List<Item> findByItemEnteredByUser( String enteredByUser);

    List<Item> findByItemStatus(ItemStatus itemStatus);
}
