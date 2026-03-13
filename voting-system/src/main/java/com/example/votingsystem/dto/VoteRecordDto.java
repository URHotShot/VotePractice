package com.example.votingsystem.dto;

public class VoteRecordDto {
    private String voterName;
    private Long itemId;
    private String itemName;

    public VoteRecordDto() {
    }

    public VoteRecordDto(String voterName, Long itemId, String itemName) {
        this.voterName = voterName;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
