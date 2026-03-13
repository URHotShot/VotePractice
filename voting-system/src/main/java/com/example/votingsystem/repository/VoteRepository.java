package com.example.votingsystem.repository;

import com.example.votingsystem.dto.VoteItemDto;
import com.example.votingsystem.dto.VoteRecordDto;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.votingsystem.dto.VoteResultDto;

import java.util.List;

@Repository
public class VoteRepository {
    private final JdbcTemplate jdbcTemplate;

    public VoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 呼叫Stored Procedure查回來的每一列資料，轉成 VoteItemDto
    public List<VoteItemDto> getAllVoteItems() {
        
        String sql = "CALL sp_get_all_vote_items()";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new VoteItemDto(
                        rs.getLong("id"),
                        rs.getString("item_name")
                )
        );
    }

    // 取得投票結果
    public List<VoteResultDto> getVoteResults() {
        String sql = "CALL sp_get_vote_results()";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new VoteResultDto(
                        rs.getLong("id"),
                        rs.getString("item_name"),
                        rs.getLong("total_votes")
                )
        );
    }

    // 取得詳細投票結果
    public List<VoteRecordDto> getVoteRecords() {
        String sql = "CALL sp_get_vote_records()";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new VoteRecordDto(
                        rs.getString("voter_name"),
                        rs.getLong("item_id"),
                        rs.getString("item_name")
                )
        );
    }

    // 投票結果加入資料庫
    public void addVoteRecord(String voterName, Long itemId) {
        String sql = "CALL sp_add_vote_record(?, ?)";
        jdbcTemplate.update(sql, voterName, itemId);
    }

    // 新增投票項目
    public void addVoteItem(String itemName) {
        String sql = "CALL sp_add_vote_item(?)";
        jdbcTemplate.update(sql, itemName);
    }

    // 更新投票項目
    public void updateVoteItem(Long id, String itemName) {
        String sql = "CALL sp_update_vote_item(?, ?)";
        jdbcTemplate.update(sql, id, itemName);
    }
}