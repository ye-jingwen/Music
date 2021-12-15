const configure = {
    state: {
        HOST: 'http://127.0.0.1:8888',   //服务器地址
        activeName: '',   //当前选中的菜单名

    },
    //取值
    getters: {
        activeName: state => {
            let activeName = state.activeName
            if (!activeName) {
                activeName = JSON.parse(window.sessionStorage.getItem('activeName'))   //如果获取不到可以从sessionStorage中获取
            }
            return activeName
        },
    },
    //设置值
    mutations: {
        setActiveName: (state, activeName) => {
            state.activeName = activeName
            window.sessionStorage.setItem('activeName', JSON.stringify(activeName))   //增加一层保险
        },
    }
}

export default configure