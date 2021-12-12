<template>
    <div class="table">
        <div class="crumbs">
            <i class="el-icon-tickets"></i>歌曲信息
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input v-model="select_word" size="mini" placeholder="请输入歌曲名" class="handle-input"></el-input>
                <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加歌曲</el-button>
                <el-button type="primary" size="mini" @click="delAll">批量删除</el-button>
            </div>
        </div>

        <!-- 歌曲列表显示 -->
        <el-table size="mini" border style="width:100%" height="500px" :data="data" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="40" />
            <el-table-column label="歌曲图片" width="110px" align="center">
                <template slot-scope="scope">
                    <div class="song-img">
                        <img :src="getUrl(scope.row.pic)" style="width:100%" />
                    </div>
                    <el-upload :action="uploadUrl(scope.row.id)" :before-upload="beforeAvatorUpload" :on-success="handleAvatorSuccess">
                        <el-button size="mini">更新图片</el-button>
                    </el-upload>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="歌手-歌名" width="120" align="center" />
            <el-table-column prop="introduction" label="专辑" width="150" align="center" />
            <el-table-column label="歌词" align="center">
                <template slot-scope="scope">
                    <ul style="height:100px;overflow:scroll;">
                        <li v-for="(item,index) in parseLyric(scope.row.lyric)" :key="index">
                            {{item}}
                        </li>
                    </ul>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="150" align="center">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 翻页 -->
        <div class="pagination">
            <el-pagination background layout="total,prev,pager,next" :current-page="currentPage" :page-size="pageSize" :total="tableData.length" @current-change="handleCurrentChange" />
        </div>

        <!-- 添加歌曲页面 -->
        <el-dialog title="添加歌曲" :visible.sync="centerDialogVisible" width="400px" center>
            <el-form :model="registerForm" ref="registerForm" label-width="80px" action="" id="tf">
                <div>
                    <label>歌名</label>
                    <el-input type="text" name="name" />
                </div>
                <div>
                    <label>专辑</label>
                    <el-input type="text" name="introduction" />
                </div>
                <div>
                    <label>歌词</label>
                    <el-input type="textarea" name="lyric" />
                </div>
                <div>
                    <label>歌曲上传</label>
                    <input type="file" name="file">
                </div>
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="centerDialogVisible = false">取消</el-button>
                <el-button size="mini" @click="insertSong">确定</el-button>
            </span>
        </el-dialog>

        <!-- 修改歌曲页面 -->
        <el-dialog title="修改歌曲" :visible.sync="editVisible" width="400px" center>
            <el-form :model="form" ref="form" label-width="80px">
                <el-form-item prop="name" label="歌手-歌名" size="mini">
                    <el-input v-model="form.name" placeholder="歌手-歌名" />
                </el-form-item>
                <el-form-item prop="introduction" label="专辑" size="mini">
                    <el-input v-model="form.introduction" placeholder="专辑" />
                </el-form-item>
                <el-form-item prop="lyric" label="歌词" size="mini">
                    <el-input v-model="form.lyric" placeholder="歌词" type="textarea" />
                </el-form-item>
            </el-form>
            <span slot="footer">
                <el-button size="mini" @click="editVisible = false">取消</el-button>
                <el-button size="mini" @click="editSave">确定</el-button>
            </span>
        </el-dialog>

        <!-- 删除歌曲页面 -->
        <el-dialog title="删除歌曲" :visible.sync="delVisible" width="300px" center>
            <div align="center">删除不可恢复，是否确定删除？</div>
            <span slot="footer">
                <el-button size="mini" @click="delVisible = false">取消</el-button>
                <el-button size="mini" @click="deleteRow">确定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { delSong, updateSong, selectBySingerId } from "../api/index";
import { mixin } from "../mixins/index";

export default {
    mixins: [mixin],
    data() {
        return {
            singerId: "", //歌手id
            singerName: "", //歌手名字
            centerDialogVisible: false, //添加弹窗是否显示
            editVisible: false, //编辑弹窗是否显示
            delVisible: false, //删除弹窗是否显示
            //添加框
            registerForm: {
                name: "",
                singerName: "",
                introduction: "",
                lyric: "",
            },
            //编辑框
            form: {
                id: "",
                name: "",
                introduction: "",
                lyric: "",
            },
            tableData: [],
            tempData: [],
            select_word: "",
            pageSize: 3, //分页每页大小
            currentPage: 1, //当前页
            idx: -1, //当前选择项
            multipleSelection: [], //哪些选项已经打勾
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
        this.singerId = this.$route.query.id;
        this.singerName = this.$route.query.name;
        this.getData();
    },
    methods: {
        //获取当前页
        handleCurrentChange(val) {
            this.currentPage = val;
        },
        //查询所有歌曲
        getData() {
            this.tempData = [];
            this.tableData = [];
            selectBySingerId(this.singerId).then((res) => {
                this.tempData = res;
                this.tableData = res;
                this.currentPage = 1;
            });
        },
        //添加歌曲
        insertSong() {
            let thisSong = this;
            var form = new FormData(document.getElementById("tf"));
            form.append("singerId", this.singerId);
            form.set("name", this.singerName + "-" + form.get("name"));
            if (!form.get("lyric")) {
                form.set("lyric", "[00:00:00]暂无歌词");
            }
            var req = new XMLHttpRequest();
            req.onreadystatechange = function () {
                //req.readyState == 4 获取到返回的完整数据
                //req.status == 200 和后台正常交互完成
                if (req.readyState == 4 && req.status == 200) {
                    let res = JSON.parse(req.response);
                    if (res.code) {
                        thisSong.getData();
                        thisSong.registerForm = {};
                        thisSong.notify(res.msg, "success");
                    } else {
                        thisSong.notify("保存失败", "error");
                    }
                }
            };
            req.open(
                "post",
                `${thisSong.$store.state.HOST}/song/insertSong`,
                false
            );
            req.send(form);
            thisSong.centerDialogVisible = false;
        },
        //更新图片
        uploadUrl(id) {
            return `${this.$store.state.HOST}/singer/updateSingerPic?id=${id}`;
        },
        //编辑歌曲信息
        handleEdit(row) {
            this.editVisible = true;
            this.form = {
                id: row.id,
                name: row.name,
                introduction: row.introduction,
                lyric: row.lyric,
            };
        },
        //保存编辑页面修改的数据
        editSave() {
            let params = new URLSearchParams();
            params.append("id", this.form.id);
            params.append("name", this.form.name);
            params.append("introduction", this.form.introduction);
            params.append("lyric", this.form.lyric);

            updateSong(params)
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
        },
        //删除一首歌曲
        deleteRow() {
            delSong(this.idx)
                .then((res) => {
                    if (res) {
                        this.getData();
                        this.notify("删除成功", "success");
                    } else {
                        this.notify("删除失败", "error");
                    }
                })
                .catch((err) => {
                    console.log(err);
                });
            this.delVisible = false;
        },
        //解析歌词
        parseLyric(text) {
            let lines = text.split("\n");
            let pattern = /\[\d{2}:\d{2}.(\d{3}|\d{2})\]/g; //定义正则表达式
            let result = [];
            for (let item of lines) {
                let value = item.replace(pattern, ""); //将数组中所有包含正则表达式模式的内容设为空
                result.push(value);
            }
            return result;
        },
    },
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}
.song-img {
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