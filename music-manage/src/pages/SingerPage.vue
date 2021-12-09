<template>
    <div class="table">
        <div class="container">
            <div class="handle-box">
                <el-input v-model="select_word" size="mini" placeholder="请输入歌手名" class="handle-input"></el-input>
                <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加歌手</el-button>
            </div>
        </div>

        <!-- 歌手列表显示 -->
        <el-table size="mini" border style="width:100%" height="500px" :data="data">
            <el-table-column label="歌手图片" width="110px" align="center">
                <template slot-scope="scope">
                    <div class="singer-img">
                        <img :src="getUrl(scope.row.pic)" style="width:100%" />
                    </div>
                    <el-upload :action="uploadUrl(scope.row.id)" :before-upload="beforeAvatorUpload" :on-success="handleAvatorSuccess">
                        <el-button size="mini">更新图片</el-button>
                    </el-upload>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="歌手" width="120" align="center" />
            <el-table-column label="性别" width="50" align="center">
                <template slot-scope="scope">
                    {{changeSex(scope.row.sex)}}
                </template>
            </el-table-column>
            <el-table-column label="生日" width="120" align="center">
                <template slot-scope="scope">
                    {{attachBirth(scope.row.birth)}}
                </template>
            </el-table-column>
            <el-table-column prop="location" label="地区" width="100" align="center" />
            <el-table-column prop="introduction" label="简介">
                <template slot-scope="scope">
                    <p style="height:100px; overflow:scroll">{{scope.row.introduction}}</p>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="150" align="center">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 翻页 -->
        <div class="pagination">
            <el-pagination background layout="total,prev,pager,next" :current-page="currentPage" :page-size="pageSize" :total="tableData.length" @current-change="handleCurrentChange" />
        </div>

        <!-- 添加歌手页面 -->
        <el-dialog title="添加歌手" :visible.sync="centerDialogVisible" width="400px" center>
            <el-form :model="registerForm" ref="registerForm" label-width="80px">
                <el-form-item prop="name" label="歌手名" size="mini">
                    <el-input v-model="registerForm.name" placeholder="歌手名" />
                </el-form-item>
                <el-form-item label="性别" size="mini">
                    <el-radio-group v-model="registerForm.sex">
                        <el-radio :label="0">女</el-radio>
                        <el-radio :label="1">男</el-radio>
                        <el-radio :label="2">组合</el-radio>
                        <el-radio :label="3">不明</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item prop="birth" label="生日" size="mini">
                    <el-date-picker type="date" placeholder="选择日期" v-model="registerForm.birth" style="width: 100%" />
                </el-form-item>
                <el-form-item prop="location" label="地区" size="mini">
                    <el-input v-model="registerForm.location" placeholder="地区" />
                </el-form-item>
                <el-form-item prop="introduction" label="简介" size="mini">
                    <el-input v-model="registerForm.introduction" placeholder="简介" type="textarea" />
                </el-form-item>
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="centerDialogVisible = false">取消</el-button>
                <el-button size="mini" @click="insertSinger">确定</el-button>
            </span>
        </el-dialog>

        <!-- 修改歌手页面 -->
        <el-dialog title="修改歌手" :visible.sync="editVisible" width="400px" center>
            <el-form :model="form" ref="form" label-width="80px">
                <el-form-item prop="name" label="歌手名" size="mini">
                    <el-input v-model="form.name" placeholder="歌手名" />
                </el-form-item>
                <el-form-item label="性别" size="mini">
                    <el-radio-group v-model="form.sex">
                        <el-radio :label="0">女</el-radio>
                        <el-radio :label="1">男</el-radio>
                        <el-radio :label="2">组合</el-radio>
                        <el-radio :label="3">不明</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="生日" size="mini">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.birth" style="width: 100%" />
                </el-form-item>
                <el-form-item prop="location" label="地区" size="mini">
                    <el-input v-model="form.location" placeholder="地区"></el-input>
                </el-form-item>
                <el-form-item prop="introduction" label="简介" size="mini">
                    <el-input v-model="form.introduction" placeholder="简介" type="textarea"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="editVisible = false">取消</el-button>
                <el-button size="mini" @click="editSave">确定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { getAllSinger, setSinger,updateSinger } from "../api/index";
import { mixin } from "../mixins/index";

export default {
    mixins: [mixin],
    data() {
        return {
            //添加弹窗是否显示
            centerDialogVisible: false,
            //编辑弹窗是否显示
            editVisible: false,
            //添加框
            registerForm: {
                name: "",
                sex: "",
                birth: "",
                location: "",
                introduction: "",
            },
            //编辑框
            form: {
                id: "",
                name: "",
                sex: "",
                birth: "",
                location: "",
                introduction: "",
            },
            tableData: [],
            tempData: [],
            select_word: "",
            pageSize: 5, //分页每页大小
            currentPage: 1, //当前页
        };
    },
    //监控多个变量
    computed: {
        //计算当前搜索结果表里的数据
        data() {
            return this.tableData.slice(
                (this.currentPage - 1) * this.pageSize,
                this.currentPage * this.pageSize
            );
        },
    },
    //监控单个变量
    watch: {
        //搜索框里面的内容发生变化时，搜索结果table列表的内容跟着它发生变化
        select_word: function () {
            if (this.select_word == "") {
                this.tableData = this.tempData;
            } else {
                this.tableData = [];
                for (let item of this.tempData) {
                    if (item.name.includes(this.select_word)) {
                        this.tableData.push(item);
                    }
                }
            }
        },
    },
    created() {
        this.getData();
    },
    methods: {
        //获取当前页
        handleCurrentChange(val) {
            this.currentPage = val;
        },
        //查询所有歌手
        getData() {
            this.tempData = [];
            this.tableData = [];
            getAllSinger().then((res) => {
                this.tempData = res;
                this.tableData = res;
                this.currentPage = 1;
            });
        },
        //添加歌手
        insertSinger() {
            let d = this.registerForm.birth;
            let datetime =
                d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
            let params = new URLSearchParams();
            params.append("name", this.registerForm.name);
            params.append("sex", this.registerForm.sex);
            params.append("pic", "/img/singerPic/singerDefault.jpg");
            params.append("birth", datetime);
            params.append("location", this.registerForm.location);
            params.append("introduction", this.registerForm.introduction);

            setSinger(params)
                .then((res) => {
                    if (res.code == 1) {
                        this.getData();
                        this.notify("添加成功", "success");
                    } else {
                        this.notify("添加失败", "error");
                    }
                })
                .catch((err) => {
                    console.log(err);
                });
            this.centerDialogVisible = false;
            this.getData();
        },
        //更新图片
        uploadUrl(id) {
            return `${this.$store.state.HOST}/singer/updateSingerPic?id=${id}`;
        },
        //编辑歌手信息
        handleEdit(row) {
            this.editVisible = true;
            this.form={
                id: row.id,
                name: row.name,
                sex: row.sex,
                birth: row.birth,
                location: row.location,
                introduction: row.introduction
            }
        },
        //保存编辑页面修改的数据
        editSave() {
            let d = new Date(this.form.birth);
            let datetime = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
            let params = new URLSearchParams();
            params.append("id", this.form.id);
            params.append("name", this.form.name);
            params.append("sex", this.form.sex);
            params.append("pic", "/img/singerPic/singerDefault.jpg");
            params.append("birth", datetime);
            params.append("location", this.form.location);
            params.append("introduction", this.form.introduction);

            updateSinger(params)
                .then((res) => {
                    if (res.code == 1) {
                        this.getData();
                        this.notify("修改成功", "success");
                    } else {
                        this.notify("修改失败", "error");
                    }
                })
                .catch((err) => {
                    console.log(err);
                });
            this.editVisible = false;
            this.getData();
        },
    },
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}
.singer-img {
    width: 100%;
    height: 88px;
    border-radius: 5px;
    margin-bottom: 5px;
    overflow: hidden;
}
.handle-input {
    width: 300px;
    display: inline-block;
}
.pageination {
    display: flex;
    justify-content: center;
}
</style>