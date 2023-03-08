package com.inventorymanagement.service;

import com.inventorymanagement.exception.ItemAlreadyExistsException;
import com.inventorymanagement.exception.ItemNotFoundException;
import com.inventorymanagement.model.Item;
import com.inventorymanagement.model.ItemStatus;
import com.inventorymanagement.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Harshith Gowda B T
 * @Date 3/7/2023
 */
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        if ( itemRepository.existsById(item.getItemId())) {
            throw new ItemAlreadyExistsException("Item with ID " + item.getItemId() + " already exists");
        }
        item.setItemEnteredDate(LocalDateTime.now());
        return itemRepository.save(item);
    }

    public Item updateItem(int itemId, Item item) {
        Item existingItem = itemRepository.findById(Math.toIntExact(itemId))
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + itemId + " not found"));
        item.setItemId(itemId);
        item.setItemEnteredDate(existingItem.getItemEnteredDate());
        item.setItemLastModifiedDate(LocalDateTime.now());
        return itemRepository.save(item);
    }

    public boolean deleteItem(int itemId) {
        if (!itemRepository.existsById(Math.toIntExact(itemId))) {
            throw new ItemNotFoundException("Item with ID " + itemId + " not found");
        }
        return itemRepository.deleteById(itemId);
    }

    public void deleteAllItems() {
        itemRepository.deleteAll();
    }

    public Item getItemById(int itemId) {
        return itemRepository.findById(Math.toIntExact(itemId))
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + itemId + " not found"));
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByStatusAndEnteredByUser(ItemStatus itemStatus, String enteredByUser) {
        if(itemStatus==null){
            return itemRepository.findByItemEnteredByUser(enteredByUser);
        }else if(enteredByUser==null){
            return itemRepository.findByItemStatus(itemStatus);
        }else {
            return itemRepository.findByItemStatusAndItemEnteredByUser(itemStatus, enteredByUser);
        }
    }

    public Page<Item> getItemsByPageAndSize(int page, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        return itemRepository.findAll(pageable);
    }
}
