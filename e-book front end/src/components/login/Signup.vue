<template>
    <div class="login-box" align="center">
            <el-container>
                <el-aside width="600px"></el-aside>
                <el-container>
                <el-header ></el-header>
                <el-main>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="user.mail_address" placeholder="请输入注册邮箱">
                        <template slot="prepend">输入邮箱</template>
                    </el-input> 
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="user.username" placeholder="请输入昵称">
                        <template slot="prepend">输入昵称</template>
                    </el-input> 
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="user.pwd" type="password" placeholder="请输入密码">
                        <template slot="prepend">输入密码</template>
                    </el-input>
                </el-col>
            </el-row>
                    <el-row>
                <el-col :span="8">
                    <el-input  v-model="user.pwd2" type="password" placeholder="请确认密码">
                        <template slot="prepend">确认密码</template>
                    </el-input>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-button id="signup" v-on:click="saveUser" style="width:100%" type="success">注册</el-button>
                </el-col>           
            </el-row>
            </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
import http from '../../http-common.js'
export default {
  data() {
    return {
        user: {
        mail_address: '',
        username: '',
        pwd: '',
        pwd2: ''
    },
    }
  },
  methods: {
      saveUser() {
          // check;
          if (this.user.mail_address == '') {
            alert('邮箱不能为空')
            return
          }
          if (this.user.mail_address.indexOf('@') == -1) {
            alert('请输入合法的邮箱地址')
            return
          }
          if (this.user.username == '') {
            alert('用户昵称不能为空')
            return
          }
          if (this.user.pwd == '') {
            alert('密码不能为空')
            return
          }
          if (this.user.pwd !== this.user.pwd2) {
            alert('请确认输入密码一致 ')
            return
          }
          var data = {
              email: this.user.mail_address,
              username: this.user.username,
              pwd: this.user.pwd,
              active: 1
          };
          http
            .post("/user/add",data)
            .then(response => {
                console.log(response.data)
                if (response.data) {
                    alert('注册成功，请登录')
                    this.$router.replace('/login') 
                    }
                if (!response.data) {alert('注册失败，邮箱已被注册')}
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
</style>
