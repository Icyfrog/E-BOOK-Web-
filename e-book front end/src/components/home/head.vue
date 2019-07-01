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
                <router-link v-if='bool' to="/admin/CheckBook" class="icon2">
                    &#xe60d;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link v-if='bool' to="/admin/AddNewBook" class="icon">
                    &#xe60d;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link v-if='bool' to='/admin/UserList' class="icon">
                    &#xe65d;
                </router-link>
            </span>
            <span class='iconfont'>
                &nbsp&nbsp
                <router-link v-if='bool' to='/admin/AllOrders' class="icon">
                    All orders
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
            bool:false
        }
    },
    mounted() {
        //location.reload();
        const data = JSON.parse(sessionStorage.getItem('login'));
        if (data.ad == 1) { this.bool = true; }
    },

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
.icon2{
    color:#00FFFF;
    font-size:25px;
}
</style>
