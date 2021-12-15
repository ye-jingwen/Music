<template>
    <div class="the-header">
        <div class="header-logo" @click="goHome">
            <svg class="icon">
                <use xlink:href="#icon-erji" />
            </svg>
            <span>Music</span>
        </div>
        <ul class="navbar">
            <li :class="{active:item.name == activeName}" v-for="item in navMsg" :key="item.path" @click="goPage(item.path,item.name)">
                {{item.name}}
            </li>
        </ul>
    </div>
</template>

<script>
import { mapGetters } from "vuex"; //mapGetter可以从工程的其他地方获取数据
import { navMsg } from "../assets/data/header";

export default {
    name: "the-header",
    data() {
        return {
            navMsg: [], //导航栏
        };
    },
    //监控
    computed: {
        ...mapGetters(["activeName"]),
    },
    created() {
        this.navMsg = navMsg;
    },
    methods: {
        //返回主页
        goHome() {
            this.$router.push({ path: "/" });
        },
        //返回子页面
        goPage(path, name) {
            this.$store.commit("setActiveName", name);
            this.$router.push({ path: path });
        },
    },
};
</script>

<style  lang="scss" scoped>
@import "../assets/css/the-header.scss";
</style>
