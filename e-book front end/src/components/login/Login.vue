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
                            <el-button id="login" v-on:click="check" style="width:100%" type="primary" >登录</el-button>
                        </el-col>
                    </el-row>
                </el-main>
            </el-container>
        </el-container>
    </div> 

</template>

<script>
import { constants } from 'fs';
export default {
  data() {
    return {
      userID: '',
      password: ''
    }
  },
  methods: {
      check() {
          if (this.userID == '1@qq.com') {
              if (this.password == 'lgd') {
                  console.log('登录成功');
                  this.$router.replace('/');
              }
              else {
                  alert("用户名或密码错误");
              }
          }
          if (this.userID == 'admin') {
              if (this.password == 'admin') {
                  console.log('登录成功');
                  this.$router.replace('/admin/userList');
              }
              else {
                  alert("用户名或密码错误");
              }
          }
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
