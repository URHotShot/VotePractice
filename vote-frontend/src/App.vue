<template>
  <div>
    <h1>線上投票系統</h1>

    <nav>
      <router-link to="/vote">投票頁</router-link> |
      <router-link to="/admin">管理頁</router-link> |
      <router-link to="/results">投票結果</router-link>
    </nav>

    <hr>

    <router-view />
  </div>
</template>