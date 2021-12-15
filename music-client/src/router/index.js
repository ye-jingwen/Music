import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import SongList from '@/pages/SongList'
import Singer from '@/pages/Singer'
import MyMusic from '@/pages/MyMusic'


Vue.use(Router)

export default new Router({
  routes: [    
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/songList',
      name: 'songList',
      component: SongList
    },
    {
      path: '/singer',
      name: 'singer',
      component: Singer
    },
    {
      path: '/my-music',
      name: 'my-music',
      component: MyMusic
    },
  ],
  scrollBehavior (to, from, savedPosition) {
    return { x: 0, y: 0 }
  }
})
