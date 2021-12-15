<template>
    <div class="home">
        <swiper />
    </div>
</template>

<script>
import Swiper from "../components/Swiper.vue";

export default {
    name: "home",
    components: {
      Swiper
    },
    data() {
        return {};
    },
    created() {},
    methods: {},
};
</script>

<style lang="scss" scoped>
@import "../assets/css/home.scss";
</style>
