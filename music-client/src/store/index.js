import Vue from "vue"
import Vuex from "vuex"
import configure from "./configure"
import user from "./user"
import song from "./song"

Vue.use(Vuex)

const store = new Vuex.Store({
    //输出
    modules: {
        configure,
        user,
        song,
    }
})

export default store