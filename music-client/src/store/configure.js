const configure = {
    state: {
        HOST: 'http://127.0.0.1:8888',   //服务器地址
        activeName: '',   //当前选中的菜单名
        showAside: false,  //是否显示播放中的歌曲列表
        loginIn: false,   //用户是否已登录
        isActive: false,   //当前歌曲是否已收藏/

    },
    //取值
    getters: {
        //当前选中的菜单名
        activeName: state => {
            let activeName = state.activeName
            if (!activeName) {
                activeName = JSON.parse(window.sessionStorage.getItem('activeName'))   //如果获取不到可以从sessionStorage中获取
            }
            return activeName
        },
        //是否显示播放中的歌曲列表
        showAside: state => {
            let showAside = state.showAside
            if (!showAside) {
                showAside = JSON.parse(window.sessionStorage.getItem('showAside'))   //如果获取不到可以从sessionStorage中获取
            }
            return showAside
        },
        loginIn: state => {
            let loginIn = state.loginIn
            if (!loginIn) {
                loginIn = JSON.parse(window.sessionStorage.getItem('loginIn'))   //如果获取不到可以从sessionStorage中获取
            }
            return loginIn
        },
        isActive: state => {
            let isActive = state.isActive
            if (!isActive) {
                isActive = JSON.parse(window.sessionStorage.getItem('isActive'))   //如果获取不到可以从sessionStorage中获取
            }
            return isActive
        },

    },
    //设置值
    mutations: {
        //当前选中的菜单名
        setActiveName: (state, activeName) => {
            state.activeName = activeName
            window.sessionStorage.setItem('activeName', JSON.stringify(activeName))   //增加一层保险
        },
        //是否显示播放中的歌曲列表
        setShowAside: (state, showAside) => {
            state.showAside = showAside
            window.sessionStorage.setItem('showAside', JSON.stringify(showAside))   //增加一层保险
        },
        setLoginIn: (state, loginIn) => {
            state.loginIn = loginIn
            window.sessionStorage.setItem('loginIn', JSON.stringify(loginIn))   //增加一层保险
        },
        setIsActive: (state, isActive) => {
            state.isActive = isActive
            window.sessionStorage.setItem('isActive', JSON.stringify(isActive))   //增加一层保险
        },
    }
}

export default configure