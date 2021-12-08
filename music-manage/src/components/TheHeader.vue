<template>
    <div class="header">
        <!--折叠图片-->
        <div class="collapse-btn" @click="collapseChange">
            <i class="el-icon-menu"></i>
        </div>
        <!-- 标题 -->
        <div class="logo">Music后台管理</div>
        <!-- 右侧 -->
        <div class="header-right">
            <!-- 全屏事件按钮 -->
            <div class="btn-fullscreen" @click="handleFullScreen">
                <el-tooltip :content="fullscreen ? `取消全屏` : `全屏`" placement="bottom">
                    <i class="el-icon-rank"></i>
                </el-tooltip>
            </div>
            <!-- 头像 -->
            <div class="user-avator">
                <img src="../assets/img/user.png" />
            </div>
            <!-- 下拉菜单 -->
            <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    {{ userName }}
                    <i class="el-icon-caret-bottom"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
import bus from "../assets/js/bus";

export default {
    data() {
        return {
            collapse: false,
            fullscreen: false,
        };
    },
    computed: {
        userName() {
            return localStorage.getItem("userName");
        },
    },
    methods: {
        //侧边折叠栏
        collapseChange() {
            this.collapse = !this.collapse;
            bus.$emit("collapse", this.collapse);
        },
        //全屏事件
        handleFullScreen() {
            if (this.fullscreen) {
                //对各种浏览器适配
                if (document.exitFullscreen) {
                    document.exitFullscreen();
                } else if (document.webkitCancelFullScreen) {
                    //safari 、Chrome
                    document.webkitCancelFullScreen();
                } else if (document.mozCancelFullScreen) {
                    //firefox
                    document.mozCancelFullScreen();
                } else if (document.msExitFullScreen) {
                    //ie
                    document.msExitFullScreen();
                }
            } else {
                let element = document.documentElement;
                if (element.requestFullscreen) {
                    element.requestFullscreen();
                } else if (element.webkitRequestFullScreen) {
                    //safari 、Chrome
                    element.webkitRequestFullScreen();
                } else if (element.mozRequestFullScreen) {
                    //firefox
                    element.mozRequestFullScreen();
                } else if (element.msRequestFullScreen) {
                    //ie
                    element.msRequestFullScreen();
                }
            }
            this.fullscreen = !this.fullscreen; //修改变量值与当前状态相同
        },
        //退出登录
        handleCommand(command) {
            if (command == "logout") {
                localStorage.removeItem("userName");
                this.$router.push("/");
            }
        },
    },
};
</script>

<style scoped>
.header {
    position: relative;
    background-color: #253041;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #ffffff;
}
.collapse-btn {
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
}
.header .logo {
    float: left;
    line-height: 70px;
}
.header-right {
    float: right;
    padding-right: 50px;
    display: flex;
    height: 70px;
    align-items: center;
}
.btn-fullscreen {
    transform: rotate(45deg); /* 将图标旋转45度 */
    margin-right: 5px;
    font-size: 24px;
}
.user-avator {
    margin-left: 20px;
}
.user-avator img {
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
}
.user-name {
    margin-left: 10px;
}
.el-dropdown-link {
    color: #ffffff;
    cursor: pointer;
}
</style>