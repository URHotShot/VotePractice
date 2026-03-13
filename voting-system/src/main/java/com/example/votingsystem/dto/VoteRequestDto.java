package com.example.votingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

// 接前端送來的資料
public class VoteRequestDto {

    @NotBlank(message = "物件名稱不能為空")
    @Size(max = 50, message = "物件名稱長度不能超過50個字符")
    private String voterName;
    @NotEmpty(message = "至少選擇一個投票項目")
    private List<Long> itemIds;

    public VoteRequestDto() {
    }

    public VoteRequestDto(String voterName, List<Long> itemIds) {
        this.voterName = voterName;
        this.itemIds = itemIds;
    }
    // 投票者姓名
    public String getVoterName() {
        return voterName;
    }
    
    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }
    // 投票項目ID列表
    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
