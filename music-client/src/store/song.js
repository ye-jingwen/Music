const song = {
    state: {
        listOfSongs: [],     //当前歌曲列表
        isPlay: false,          //是否播放中
        url: '',                //歌曲地址
        id: '',                  //歌曲id
        playButtonUrl: '#icon-startPlay',   //播放状态的图标
        duration: 0,                //音乐时长
        curTime: 0,                //当前音乐的播放位置
        changeTime: 0,              //指定播放时刻
        title: '',                  //歌名
        artist: '',                 //歌手名
        picUrl: '',                 //歌曲图片
        autoNext: true,             //用于自动触发播放下一首
        lyric: [],                  //未处理的歌词数据
        tempList: {},               //单个歌单信息或歌手信息
        listIndex: null,            //当前歌曲在歌单中的位置
        volume: 50                  //音量
    },
    //获取值
    getters: {
        //当前歌曲列表
        listOfSongs: state => {
            let listOfSongs = state.listOfSongs;
            if (!listOfSongs.length) {
                listOfSongs = JSON.parse(window.sessionStorage.getItem('listOfSongs') || null);
            }
            return listOfSongs;
        },
        //播放状态
        isPlay: state => {
            let isPlay = state.isPlay;
            if (!isPlay) {
                isPlay = JSON.parse(window.sessionStorage.getItem('isPlay') || null);
            }
            return isPlay;
        },
        //歌曲地址
        url: state => {
            let url = state.url;
            if (!url) {
                url = JSON.parse(window.sessionStorage.getItem('url') || null);
            }
            return url;
        },
        //歌曲id
        id: state => {
            let id = state.id;
            if (!id) {
                id = JSON.parse(window.sessionStorage.getItem('id') || null);
            }
            return id;
        },
        //播放状态的图标
        playButtonUrl: state => {
            let playButtonUrl = state.playButtonUrl;
            if (!playButtonUrl) {
                playButtonUrl = JSON.parse(window.sessionStorage.getItem('playButtonUrl') || null);
            }
            return playButtonUrl;
        },
        //音乐时长
        duration: state => {
            let duration = state.duration;
            if (!duration) {
                duration = JSON.parse(window.sessionStorage.getItem('duration') || null);
            }
            return duration;
        },
        //指定播放时刻
        curTime: state => {
            let curTime = state.curTime;
            if (!curTime) {
                curTime = JSON.parse(window.sessionStorage.getItem('curTime') || null);
            }
            return curTime;
        },
        //指定播放时刻
        changeTime: state => {
            let changeTime = state.changeTime;
            if (!changeTime) {
                changeTime = JSON.parse(window.sessionStorage.getItem('changeTime') || null);
            }
            return changeTime;
        },
        //歌名
        title: state => {
            let title = state.title;
            if (!title) {
                title = JSON.parse(window.sessionStorage.getItem('title') || null);
            }
            return title;
        },
        //歌手名
        artist: state => {
            let artist = state.artist;
            if (!artist) {
                artist = JSON.parse(window.sessionStorage.getItem('artist') || null);
            }
            return artist;
        },
        //歌曲图片
        picUrl: state => {
            let picUrl = state.picUrl;
            if (!picUrl) {
                picUrl = JSON.parse(window.sessionStorage.getItem('picUrl') || null);
            }
            return picUrl;
        },
        //用于自动触发播放下一首
        autoNext: state => {
            let autoNext = state.autoNext;
            if (!autoNext) {
                autoNext = JSON.parse(window.sessionStorage.getItem('autoNext') || null);
            }
            return autoNext;
        },
        //未处理的歌词数据
        lyric: state => {
            let lyric = state.lyric;
            if (!lyric) {
                lyric = JSON.parse(window.sessionStorage.getItem('lyric') || null);
            }
            return lyric;
        },
        //单个歌单信息或歌手信息
        tempList: state => {
            let tempList = state.tempList;
            if (!tempList) {
                tempList = JSON.parse(window.sessionStorage.getItem('tempList') || null);
            }
            return tempList;
        },
        //当前歌曲在歌单中的位置
        listIndex: state => {
            let listIndex = state.listIndex;
            if (!listIndex) {
                listIndex = JSON.parse(window.sessionStorage.getItem('listIndex') || null);
            }
            return listIndex;
        },
        //音量
        volume: state => {
            let volume = state.volume;
            if (!volume) {
                volume = JSON.parse(window.sessionStorage.getItem('volume') || null);
            }
            return volume;
        }
    },
    //设置值
    mutations: {
        //当前歌曲列表
        setListOfSongs: (state, listOfSongs) => {
            state.listOfSongs = listOfSongs;
            window.sessionStorage.setItem('listOfSongs', JSON.stringify(listOfSongs));
        },
        //播放状态
        setIsPlay: (state, isPlay) => {
            state.isPlay = isPlay;
            window.sessionStorage.setItem('isPlay', JSON.stringify(isPlay));
        },
        //歌曲地址
        setUrl: (state, url) => {
            state.url = url;
            window.sessionStorage.setItem('url', JSON.stringify(url));
        },
        //歌曲id
        setId: (state, id) => {
            state.id = id;
            window.sessionStorage.setItem('id', JSON.stringify(id));
        },
        //播放状态的图标
        setPlayButtonUrl: (state, playButtonUrl) => {
            state.playButtonUrl = playButtonUrl;
            window.sessionStorage.setItem('playButtonUrl', JSON.stringify(playButtonUrl));
        },
        //音乐时长
        setDuration: (state, duration) => {
            state.duration = duration;
            window.sessionStorage.setItem('duration', JSON.stringify(duration));
        },
        //当前音乐的播放位置
        setCurTime: (state, curTime) => {
            state.curTime = curTime;
            window.sessionStorage.setItem('curTime', JSON.stringify(curTime));
        },
        //指定播放时刻
        setChangeTime: (state, changeTime) => {
            state.changeTime = changeTime;
            window.sessionStorage.setItem('changeTime', JSON.stringify(changeTime));
        },
        //歌名
        setTitle: (state, title) => {
            state.title = title;
            window.sessionStorage.setItem('title', JSON.stringify(title));
        },
        //歌手名
        setArtist: (state, artist) => {
            state.artist = artist;
            window.sessionStorage.setItem('artist', JSON.stringify(artist));
        },
        //歌曲图片
        setPicUrl: (state, picUrl) => {
            state.picUrl = picUrl;
            window.sessionStorage.setItem('picUrl', JSON.stringify(picUrl));
        },
        //用于自动触发播放下一首
        setAutoNext: (state, autoNext) => {
            state.autoNext = autoNext;
            window.sessionStorage.setItem('autoNext', JSON.stringify(autoNext));
        },
        //未处理的歌词数据
        setLyric: (state, lyric) => {
            state.lyric = lyric;
            window.sessionStorage.setItem('lyric', JSON.stringify(lyric));
        },
        //单个歌单信息或歌手信息
        setTempList: (state, tempList) => {
            state.tempList = tempList;
            window.sessionStorage.setItem('tempList', JSON.stringify(tempList));
        },
        //当前歌曲在歌单中的位置
        setListIndex: (state, listIndex) => {
            state.listIndex = listIndex;
            window.sessionStorage.setItem('listIndex', JSON.stringify(listIndex));
        },
        //音量
        setVolume: (state, volume) => {
            state.volume = volume;
            window.sessionStorage.setItem('volume', JSON.stringify(volume));
        }
    }
}

export default song