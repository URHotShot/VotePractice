import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080"
});

// 投票 API
// 取得所有投票項目
export const getVoteItems = () => api.get("/api/items");
// 取得投票結果
export const getVoteResults = () => api.get("/api/results");
// 送出投票
export const submitVote = (data) => api.post("/api/vote", data);
// 取得詳細投票紀錄
export const getVoteRecords = () => api.get("/api/vote-records");
// 管理員：新增投票項目
export const createItem = (data) => api.post("/api/admin/items", data);
// 管理員：更新投票項目
export const updateItem = (id, data) => api.put(`/api/admin/items/${id}`, data);

export default api;