<template>
    <div class="song-audio">
        <audio id="player" :src="url" controls="controls" preload="true" @canplay="startPlay" @ended="ended" />
    </div>
</template>

<script>
import { mapGetters } from "vuex";   //监控store中的值

export default {
    name: "song-audio",
    computed: {
        ...mapGetters(["id", "url", "isPlay"]),
    },
    watch: {
        //监听现在状态是播放还是暂停
        isPlay: function () {
            this.togglePlay();
        },
    },
    methods: {
        //获取连接后播放
        startPlay() {
            let player = document.querySelector("#player");
            //开始播放
            player.play();
        },
        //播放完成之后触发
        ended() {
            this.isPlay = false;
        },
        //暂停播放
        togglePlay() {
            let player = document.querySelector("#player");
            if (this.isPlay) {
                player.play();
            } else {
                player.pause();
            }
        },
    },
};
</script>

<style>
.song-audio {
    display: none;
}
</style>