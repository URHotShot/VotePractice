<template>
  <div>
    <h2>投票頁</h2>

    <div>
      <label for="voterName">投票人姓名：</label>
      <input
        id="voterName"
        v-model="voterName"
        type="text"
        placeholder="請輸入姓名"
      />
    </div>

    <br />

    <p v-if="message">{{ message }}</p>

    <table border="1" cellpadding="8">
      <thead>
        <tr>
          <th>選擇</th>
          <th>ID</th>
          <th>項目名稱</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in items" :key="item.id">
          <td>
            <input
              type="checkbox"
              :value="item.id"
              v-model="selectedItemIds"
            />
          </td>
          <td>{{ item.id }}</td>
          <td>{{ item.itemName }}</td>
        </tr>
      </tbody>
    </table>

    <br />

    <button @click="vote">送出投票</button>
  </div>
</template>

<script>
import { getVoteItems, submitVote } from "../api/voteApi";

export default {
  data() {
    return {
      voterName: "",
      items: [],
      selectedItemIds: [],
      message: "",
    };
  },
  methods: {
    async fetchItems() {
      try {
        const res = await getVoteItems();
        this.items = res.data;
      } catch (error) {
        this.message = "載入投票項目失敗";
        console.error("fetchItems error:", error);
      }
    },

    async vote() {
      if (!this.voterName.trim()) {
        this.message = "請輸入投票人姓名";
        return;
      }

      if (this.selectedItemIds.length === 0) {
        this.message = "請至少選擇一個投票項目";
        return;
      }

      try {
        const res = await submitVote({
          voterName: this.voterName,
          itemIds: this.selectedItemIds,
        });

        console.log("投票成功:", res.data);
        this.message = "投票成功";
        this.voterName = "";
        this.selectedItemIds = [];
      } catch (error) {
        console.error("投票失敗:", error);
        console.error("response:", error.response);
        this.message = error.response?.data?.message || "投票失敗";
      }
    },
  },
  mounted() {
    this.fetchItems();
  },
};
</script>