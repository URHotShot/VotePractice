<template>
  <div>
    <h2>投票結果</h2>

    <div v-for="result in results" :key="result.id" class="result-box">

      <h3>
        {{ result.itemName }} ({{ result.totalVotes }} 票)
      </h3>

      <ul>
        <li v-for="record in getRecordsByItem(result.id)" :key="record.voterName + record.itemId">
          {{ record.voterName }}
        </li>
      </ul>

    </div>

  </div>
</template>

<script>
import { getVoteResults, getVoteRecords } from "../api/voteApi";

export default {

  data() {
    return {
      results: [],
      records: []
    };
  },

  methods: {

    async loadData() {
      try {

        const resultRes = await getVoteResults();
        const recordRes = await getVoteRecords();

        this.results = resultRes.data;
        this.records = recordRes.data;

      } catch (error) {
        console.error(error);
      }
    },

    getRecordsByItem(itemId) {
      return this.records.filter(r => r.itemId === itemId);
    }

  },

  mounted() {
    this.loadData();
  }

};
</script>

<style>

.result-box{
  border:1px solid #ccc;
  padding:15px;
  margin-bottom:20px;
}

</style>