<template>
  <div>
    <h2>後台管理投票項目</h2>

    <div>
      <input v-model="newItemName" placeholder="請輸入新的投票項目名稱" />
      <button @click="addItem">新增</button>
    </div>

    <p v-if="message">{{ message }}</p>

    <table border="1" cellpadding="8">
      <thead>
        <tr>
          <th>ID</th>
          <th>項目名稱</th>
          <th>修改名稱</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in items" :key="item.itemId">
          <td>{{ item.id }}</td>
          <td>{{ item.itemName }}</td>
          <td>
            <input v-model="item.editName" placeholder="輸入新名稱" />
          </td>
          <td>
            <button @click="editItem(item)">更新</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { getVoteItems, createItem, updateItem } from "../api/voteApi";

export default {
  data() {
    return {
      items: [],
      newItemName: "",
      message: "",
    };
  },
  methods: {
    async fetchItems() {
      try {
        const res = await getVoteItems();
        this.items = res.data.map((item) => ({
          ...item,
          editName: item.itemName,
        }));
      } catch (error) {
        this.message = "載入投票項目失敗";
        console.error(error);
      }
    },

    async addItem() {
      if (!this.newItemName.trim()) {
        this.message = "投票項目名稱不能為空";
        return;
      }

      try {
        await createItem({
          itemName: this.newItemName,
        });
        this.message = "新增成功";
        this.newItemName = "";
        this.fetchItems();
      } catch (error) {
        this.message = "新增失敗";
        console.error(error);
      }
    },

    async editItem(item) {
      if (!item.editName.trim()) {
        this.message = "更新名稱不能為空";
        return;
      }

      try {
        await updateItem(item.id, {
          itemName: item.editName,
        });
        this.message = "更新成功";
        this.fetchItems();
      } catch (error) {
        this.message = "更新失敗";
        console.error(error);
      }
    },
  },
  mounted() {
    this.fetchItems();
  },
};
</script>