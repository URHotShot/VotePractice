package com.example.votingsystem.service;

import com.example.votingsystem.dto.VoteItemDto;
import com.example.votingsystem.repository.VoteRepository;
import org.springframework.stereotype.Service;

import com.example.votingsystem.dto.VoteResultDto;
import com.example.votingsystem.dto.VoteRecordDto;
import com.example.votingsystem.dto.VoteRequestDto;
import org.springframework.transaction.annotation.Transactional;

import com.example.votingsystem.dto.CreateVoteItemRequestDto;
import com.example.votingsystem.dto.UpdateVoteItemRequestDto;

import java.util.List;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    // Repository 注入
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    // 取得投票項目
    public List<VoteItemDto> getAllVoteItems() {
        return voteRepository.getAllVoteItems();
    }

    // 取得投票結果
    public List<VoteResultDto> getVoteResults() {
        return voteRepository.getVoteResults();
    }

    // 取得詳細投票結果
    public List<VoteRecordDto> getVoteRecords() {
        return voteRepository.getVoteRecords();
    }

    // Transaction 防止資料錯亂
    @Transactional
    public void submitVote(VoteRequestDto request) {
        for (Long itemId : request.getItemIds()) {
            voteRepository.addVoteRecord(request.getVoterName(), itemId);
        }
    }

    // 新增投票項目
    public void addVoteItem(CreateVoteItemRequestDto request) {
        voteRepository.addVoteItem(request.getItemName());
    }

    // 更新投票項目
    public void updateVoteItem(Long id, UpdateVoteItemRequestDto request) {
        voteRepository.updateVoteItem(id, request.getItemName());
    }
}

