package com.example.votingsystem.controller;

import com.example.votingsystem.dto.VoteItemDto;
import com.example.votingsystem.service.VoteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.votingsystem.dto.VoteResultDto;

import com.example.votingsystem.dto.VoteRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.votingsystem.dto.VoteRecordDto;
import com.example.votingsystem.dto.CreateVoteItemRequestDto;

import com.example.votingsystem.dto.UpdateVoteItemRequestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class VoteController {
    // Service 注入
    private final VoteService voteService;

    // 建構子注入 Service
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    // 取得投票項目
    @GetMapping("/api/items")
    public List<VoteItemDto> getAllVoteItems() {
        return voteService.getAllVoteItems();
    }

    // 取得投票結果
    @GetMapping("/api/results")
    public List<VoteResultDto> getVoteResults() {
        return voteService.getVoteResults();
    }

    // 詳細投票結果
    @GetMapping("/api/vote-records")
    public List<VoteRecordDto> getVoteRecords() {
        return voteService.getVoteRecords();
    }

    // 投票
    @PostMapping("/api/vote")
    public String submitVote(@Valid @RequestBody VoteRequestDto request) {
        voteService.submitVote(request);
        return "Vote submitted successfully";
    }

    // 新增投票項目
    @PostMapping("/api/admin/items")
    public String addVoteItem(@Valid @RequestBody CreateVoteItemRequestDto request) {
        voteService.addVoteItem(request);
        return "Vote item created successfully";
    }

    // 更新投票項目
    @PutMapping("/api/admin/items/{id}")
    public String updateVoteItem(@PathVariable Long id,
                                @Valid @RequestBody UpdateVoteItemRequestDto request) {
        voteService.updateVoteItem(id, request);
        return "Vote item updated successfully";
    }
}

