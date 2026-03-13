-- test
INSERT INTO vote_item (item_name)
VALUES
('電腦'),
('滑鼠');

INSERT INTO vote_record (voter_name, vote_item_id)
VALUES
('Leo', 1),
('Sandy', 1),
('Sandy', 2),
('Randy', 2),
('RSY', 2);

SELECT
    vi.id,
    vi.item_name,
    COUNT(vr.id) AS total_votes
FROM vote_item vi
LEFT JOIN vote_record vr
    ON vi.id = vr.vote_item_id
GROUP BY vi.id, vi.item_name;

SELECT * FROM vote_item;
SELECT * FROM vote_record;