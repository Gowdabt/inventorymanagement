package com.inventorymanagement.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
/**
 * @author Harshith Gowda B T
 * @Date 3/7/2023
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private String itemName;
    private String itemEnteredByUser;
    private LocalDateTime itemEnteredDate;
    private Double itemBuyingPrice;
    private Double itemSellingPrice;
    private LocalDateTime itemLastModifiedDate;
    private String itemLastModifiedByUser;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Item() {
    }

//    public Item(int itemId, String itemName, String itemEnteredByUser, LocalDateTime itemEnteredDate, Double itemBuyingPrice, Double itemSellingPrice, LocalDateTime itemLastModifiedDate, String itemLastModifiedByUser, ItemStatus itemStatus) {
//        this.itemId = itemId;
//        this.itemName = itemName;
//        this.itemEnteredByUser = itemEnteredByUser;
//        this.itemEnteredDate = itemEnteredDate;
//        this.itemBuyingPrice = itemBuyingPrice;
//        this.itemSellingPrice = itemSellingPrice;
//        this.itemLastModifiedDate = itemLastModifiedDate;
//        this.itemLastModifiedByUser = itemLastModifiedByUser;
//        this.itemStatus = itemStatus;
//    }

    public Item(String itemName, String itemEnteredByUser, LocalDateTime itemEnteredDate, Double itemBuyingPrice, Double itemSellingPrice, LocalDateTime itemLastModifiedDate, String itemLastModifiedByUser, ItemStatus itemStatus) {
        this.itemName = itemName;
        this.itemEnteredByUser = itemEnteredByUser;
        this.itemEnteredDate = itemEnteredDate;
        this.itemBuyingPrice = itemBuyingPrice;
        this.itemSellingPrice = itemSellingPrice;
        this.itemLastModifiedDate = itemLastModifiedDate;
        this.itemLastModifiedByUser = itemLastModifiedByUser;
        this.itemStatus = itemStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public LocalDateTime getItemEnteredDate() {
        return itemEnteredDate;
    }

    public void setItemEnteredDate(LocalDateTime itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public Double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public void setItemBuyingPrice(Double itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public Double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(Double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public LocalDateTime getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public void setItemLastModifiedDate(LocalDateTime itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public String getItemLastModifiedByUser() {
        return itemLastModifiedByUser;
    }

    public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
        this.itemLastModifiedByUser = itemLastModifiedByUser;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemEnteredByUser='" + itemEnteredByUser + '\'' +
                ", itemEnteredDate=" + itemEnteredDate +
                ", itemBuyingPrice=" + itemBuyingPrice +
                ", itemSellingPrice=" + itemSellingPrice +
                ", itemLastModifiedDate=" + itemLastModifiedDate +
                ", itemLastModifiedByUser='" + itemLastModifiedByUser + '\'' +
                ", itemStatus=" + itemStatus +
                '}';
    }
}

