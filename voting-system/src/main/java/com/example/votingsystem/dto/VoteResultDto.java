package com.example.votingsystem.dto;

public class VoteResultDto {
    private Long id;
    private String itemName;
    private Long totalVotes;

    public VoteResultDto() {
    }

    public VoteResultDto(Long id, String itemName, Long totalVotes) {
        this.id = id;
        this.itemName = itemName;
        this.totalVotes = totalVotes;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
    }
}
