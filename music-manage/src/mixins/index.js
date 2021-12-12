export const mixin = {
    methods: {
        //提示信息
        notify(title, type) {
            this.$notify({
                title: title,
                type: type
            })
        },
        //根据相对地址获取绝对地址
        getUrl(url) {
            return `${this.$store.state.HOST}/${url}`
        },
        //获取性别中文
        changeSex(value) {
            if (value == 0) {
                return '女';
            }
            if (value == 1) {
                return '男';
            }
            if (value == 2) {
                return '组合';
            }
            if (value == 3) {
                return '不明';
            }
            return value;
        },
        //获取生日
        attachBirth(val) {
            return String(val).substr(0, 10);
        },
        //图片上传之前的校验
        beforeAvatorUpload(file) {
            const isJPG = (file.type === 'image/jpeg') || (file.type === 'image/png');
            if (!isJPG) {
                this.$message.error("上传的头像图片只能是jpg或png格式");
                return false;
            }
            const isLt50MB = (file.size / 1024 / 1024) < 50;
            if (!isLt50MB) {
                this.$message.error("上传的头像图片大小不能超过50MB");
                return false;
            }
            return true;
        },
        //上传图片成功
        handleAvatorSuccess(res) {
            let thisPic = this;
            if (res.code == 1) {
                thisPic.getData();
                thisPic.$notify({
                    title: '上传成功',
                    type: 'success'
                });
            } else {
                thisPic.$notify({
                    title: '上传失败',
                    type: 'error'
                });
            }
        },
        //弹出删除窗口
        handleDelete(id) {
            this.idx = id;
            this.delVisible = true;
        },
        //把已选择的项赋值给multipleSelection
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        //批量删除已经选择的项
        delAll() {
            for (let item of this.multipleSelection) {
                this.handleDelete(item.id);
                this.deleteRow();
            }
            this.multipleSelection = [];
        }
    }
}