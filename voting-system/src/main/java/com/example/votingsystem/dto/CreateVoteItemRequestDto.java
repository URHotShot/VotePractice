package com.example.votingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// 新增投票項目
public class CreateVoteItemRequestDto {

    @NotBlank(message = "物件名稱不能為空")
    @Size(max = 100, message = "物件名稱長度不能超過100個字符")
    private String itemName;

    public CreateVoteItemRequestDto() {
    }

    public CreateVoteItemRequestDto(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
