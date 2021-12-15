<template>
    <div class="home">
        <swiper />
        <div class="section" v-for="(item,index) in songsList" :key="index">
            <div class="section-title">
                {{item.name}}
            </div>
            <content-list :contentList="item.list" />
        </div>
    </div>
</template>

<script>
import Swiper from "../components/Swiper.vue";
import contentList from "../components/ContentList";
import { getAllSongList, getAllSinger } from "../api/index";

export default {
    name: "home",
    components: {
        Swiper,
        contentList,
    },
    data() {
        return {
            songsList: [
                { name: "歌单", list: [] },
                { name: "歌手", list: [] },
            ],
        };
    },
    created() {
        this.getSongList();
        this.getSingerList();
    },
    methods: {
        //获取前十条歌单
        getSongList() {
            getAllSongList()
                .then((res) => {
                    this.songsList[0].list = res.slice(0, 10); //选取前10个
                })
                .catch((err) => {
                    console.log(err);
                });
        },
        //获取前十名歌手
        getSingerList() {
            getAllSinger()
                .then((res) => {
                    this.songsList[1].list = res.slice(0, 10);
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/home.scss";
</style>
