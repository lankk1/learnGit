/**
 * Created by slipkinem on 2016/12/8.
 */
'use strict'
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Login from '../components/user/login.vue'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/home',
      component: Home,
      name: 'Home',
      redirect: '/home/table',
      children: [
        {
          path: 'product', name: '产品', component: resolve => require(['../components/nav/Table.vue'], resolve)
        },
        {
          path: 'message', name: '留言信息', component: resolve => require(['../components/nav/MessageTable.vue'], resolve)
        },
        {
          path: 'news', name: '新闻', component: resolve => require(['../components/nav/News.vue'], resolve)
        }
      ]
    },
    {
      path: '/login', name: 'Login', component: Login
    },
    {
      path: '*', redirect: '/login'
    }
  ]
})
