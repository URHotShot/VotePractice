import { createRouter, createWebHistory } from "vue-router";
import AdminView from "../views/AdminView.vue";
import VoteView from "../views/VoteView.vue";
import ResultView from "../views/ResultView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      redirect: "/vote"
    },
    {
      path: "/vote",
      component: VoteView
    },
    {
      path: "/admin",
      component: AdminView
    },
    {
    path: "/results",
    component: ResultView
    }
  ]
});

export default router;