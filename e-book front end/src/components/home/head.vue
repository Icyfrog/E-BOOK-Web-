<template>
    <div class="head">    
        <div class="header-left">
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <span>
                <router-link to="/news">新闻公告</router-link>
                &nbsp&nbsp&nbsp&nbsp&nbsp
            </span>
            <span>
                <router-link to="/">图书列表</router-link>
                &nbsp&nbsp&nbsp&nbsp&nbsp
            </span>
            <span>
                <router-link to="/reco">推荐图书</router-link>
                &nbsp&nbsp&nbsp&nbsp&nbsp
            </span>
        </div>
        <div class="header-search">
            <router-link to="/joinus">加入我们</router-link>
        </div>
        <div class="header-right">
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link to="/" class="icon">
                    &#xe60d;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link to="/cart" class="icon">
                    &#xe60e;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link :to='way' class="icon">
                    &#xe65d;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link to="/signup" class="icon">
                    注册
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link to="/login" class="icon">
                    登录
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link to="/order" class="icon">
                    订单
                </router-link>
            </span>
            <span>
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            </span>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            way:'/reco'
        }
    }

}
</script>

<style scpoed>
.head{
  background-color:	#696969 ;
  height: 50px;
  line-height: 50px;
  display: flex;
}
.header-search{
    flex:1;
}
.icon{
    color:#FFFFFF;
    font-size:25px;
}
.header-left {
    color:#E6E6E6
}
</style>
