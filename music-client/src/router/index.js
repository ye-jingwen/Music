import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import SongList from '@/pages/SongList'
import Singer from '@/pages/Singer'
import MyMusic from '@/pages/MyMusic'
import Search from '@/pages/Search';
import Lyric from '@/pages/Lyric';
import SignUp from '@/pages/SignUp';
import LoginIn from '@/pages/LoginIn';
import Setting from '@/pages/Setting';
import SingerAlbum from '@/pages/SingerAlbum';
import SongListAlbum from '@/pages/SongListAlbum';

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
    {
      path: '/search',
      name: 'search',
      component: Search
    },
    {
      path: '/lyric',
      name: 'lyric',
      component: Lyric
    },
    {
      path: '/sign-up',
      name: 'sign-up',
      component: SignUp
    },
    {
      path: '/login-in',
      name: 'login-in',
      component: LoginIn
    },
    {
      path: '/setting',
      name: 'setting',
      component: Setting
    },
    {
      path: '/singer-album/:id',
      name: 'singer-album',
      component: SingerAlbum
    },
    {
      path: '/song-list-album/:id',
      name: 'song-list-album',
      component: SongListAlbum
    }
  ],
  scrollBehavior(to, from, savedPosition) {
    return { x: 0, y: 0 }
  }
})
