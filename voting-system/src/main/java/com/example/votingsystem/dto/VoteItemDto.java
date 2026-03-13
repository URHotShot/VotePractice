package com.example.votingsystem.dto;

// 接住資料庫查出來的投票項目資料
// 回傳給前端 JSON
public class VoteItemDto {
    private Long id;
    private String itemName;

    public VoteItemDto() {
    }

    public VoteItemDto(Long id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
