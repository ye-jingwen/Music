<template>
    <div class="header">
        <!--折叠图片-->
        <div class="collapse-btn" @click="collapseChange">
            <i class="el-icon-menu"></i>
        </div>
    </div>
</template>

<script>
import bus from "../assets/js/bus";

export default{
    data(){
        return{
            collapse:false
        }
    },
    methods:{
        collapseChange(){
            this.collapse=!this.collapse;
            bus.$emit('collapse',this.collapse);
        }
    }
}
</script>

<style scoped>
.header{
    position: relative;
    background-color: #253041;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #ffffff;
}
.collapse-btn{
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
}
</style>