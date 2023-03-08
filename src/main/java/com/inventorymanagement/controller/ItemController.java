package com.inventorymanagement.controller;

import com.inventorymanagement.model.Item;
import com.inventorymanagement.model.ItemStatus;
import com.inventorymanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Harshith Gowda B T
 * @Date 3/7/2023
 */
@RestController
@RequestMapping("/app/item")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable int itemId, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(itemId, item);
        if (updatedItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable int itemId) {
        boolean deleted = itemService.deleteItem(itemId);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllItems() {
        itemService.deleteAllItems();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable int itemId) {
        Item item = itemService.getItemById(itemId);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping(params = {"itemStatus", "itemEnteredByUser"})
    public ResponseEntity<List<Item>> getItemsByStatusAndEnteredByUser(@RequestParam ItemStatus itemStatus, @RequestParam String itemEnteredByUser) {
        List<Item> items = itemService.getItemsByStatusAndEnteredByUser(itemStatus, itemEnteredByUser);
        return ResponseEntity.ok(items);
    }

    @GetMapping(params = {"pageSize", "page", "sortBy"})
    public ResponseEntity<Page<Item>> getItemsByPageAndSort(@RequestParam int pageSize, @RequestParam int page, @RequestParam String sortBy) {
        Page<Item> items = itemService.getItemsByPageAndSize(pageSize, page, sortBy);
        return ResponseEntity.ok(items);
    }
}

