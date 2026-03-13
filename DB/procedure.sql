USE vote_esun;

DROP PROCEDURE IF EXISTS sp_get_all_vote_items;
DROP PROCEDURE IF EXISTS sp_add_vote_item;
DROP PROCEDURE IF EXISTS sp_update_vote_item;
DROP PROCEDURE IF EXISTS sp_delete_vote_item;
DROP PROCEDURE IF EXISTS sp_get_vote_results;
DROP PROCEDURE IF EXISTS sp_add_vote_record;
DROP PROCEDURE IF EXISTS sp_get_vote_records;

DELIMITER $$

-- 查全部投票項目
CREATE PROCEDURE sp_get_all_vote_items()
BEGIN
    SELECT
        id,
        item_name
    FROM vote_item
    ORDER BY id;
END $$

-- 新增投票項目
CREATE PROCEDURE sp_add_vote_item(
    IN p_item_name VARCHAR(100)
)
BEGIN
    INSERT INTO vote_item (item_name)
    VALUES (p_item_name);
END $$

-- -- 新增投票項目
CREATE PROCEDURE sp_update_vote_item(
    IN p_id BIGINT,
    IN p_item_name VARCHAR(100)
)
BEGIN
    UPDATE vote_item
    SET item_name = p_item_name
    WHERE id = p_id;
END $$

-- 刪除投票項目
CREATE PROCEDURE sp_delete_vote_item(
    IN p_id BIGINT
)
BEGIN
    DELETE FROM vote_item
    WHERE id = p_id;
END $$

-- 查投票結果
CREATE PROCEDURE sp_get_vote_results()
BEGIN
    SELECT
        vi.id,
        vi.item_name,
        COUNT(vr.id) AS total_votes
    FROM vote_item vi
    LEFT JOIN vote_record vr
        ON vi.id = vr.vote_item_id
    GROUP BY vi.id, vi.item_name
    ORDER BY vi.id;
END $$

-- 查詳細投票紀錄
CREATE PROCEDURE sp_get_vote_records()
BEGIN
    SELECT vr.voter_name, vr.vote_item_id, vi.item_name
    FROM vote_record vr
    JOIN vote_item vi ON vr.vote_item_id = vi.id
    ORDER BY vr.voter_name, vr.vote_item_id;
END $$

-- 新增投票紀錄
CREATE PROCEDURE sp_add_vote_record(
    IN p_voter_name VARCHAR(50),
    IN p_vote_item_id BIGINT
)
BEGIN
    INSERT INTO vote_record (voter_name, vote_item_id)
    VALUES (p_voter_name, p_vote_item_id);
END $$

DELIMITER ;