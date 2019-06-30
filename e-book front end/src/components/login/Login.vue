<template>
    <div class="login-box" align="center">
        <h1> E-BOOK
        </h1>
        <el-container>
        <el-aside width="600px"></el-aside>
            <el-container>
                <el-header ></el-header>
                <el-main>
                    <el-row>
                        <el-col :span="10">
                            <el-input  v-model="userID" placeholder="请输入帐号">
                                <template slot="prepend">帐号</template>
                            </el-input> 
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="10">
                            <el-input  v-model="password" type="password" placeholder="请输入密码">
                                <template slot="prepend">密码</template>
                            </el-input>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="10">
                            <el-button id="login" v-on:click="login" style="width:100%" type="primary" >登录</el-button>
                        </el-col>
                    </el-row>
                </el-main>
            </el-container>
        </el-container>
    </div> 

</template>

<script>
import { constants } from 'fs';
import http from '../../http-common.js'
export default {
  data() {
    return {
      userID: '',
      password: ''
    }
  },
  methods: {
      login() {
          // check
        if (this.userID == '' || this.password == '' ){
            alert("用户名或密码为空");
          }
        
        var data = {
            email: this.userID,
            pwd: this.password
        };
        http
            .get("/user/loginTest",{params:{email:data.email,pwd:data.pwd}})
            .then(response => {
                console.log(response.data)
                sessionStorage.removeItem('login');
                if (response.data.active == 0) {
                    alert('您的账户已被禁用')
                }
                else if (response.data == 'WrongPwd') {
                    alert('登录失败，账号或密码错误')
                }
                else if (response.data == 'wrongemail') {
                    alert('登录失败，账号不存在')
                }
                else{
                    alert('登录成功')
                    sessionStorage.setItem('login',JSON.stringify(response.data));
                    this.$router.replace('/')
                }
            })
            .finally(() => {
                this.loading = false
            })
            .catch(e => {
                console.log(e)
            })
      }
  }
}

</script>

<style scoped>
.login-box{

    height: 100%;
}
.el-header {
    color: #333;
    text-align: center;
    line-height: 500px;
  }
.el-main{
}
</style>
