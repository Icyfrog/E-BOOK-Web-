<template>
    <div class="login-box" align="center">
            <el-container>
                <el-aside width="600px"></el-aside>
                <el-container>
                <el-header ></el-header>
                <el-main>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="book.isbn" placeholder="请输入ISBN">
                        <template slot="prepend">输入ISBN</template>
                    </el-input> 
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="book.name" placeholder="请输入书名">
                        <template slot="prepend">输入书名</template>
                    </el-input> 
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="book.author"  placeholder="请输入作者">
                        <template slot="prepend">输入作者</template>
                    </el-input>
                </el-col>
            </el-row>
                    <el-row>
                <el-col :span="8">
                    <el-input  v-model="book.price"  placeholder="请输入价格">
                        <template slot="prepend">输入价格</template>
                    </el-input>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-input  v-model="book.inventory"  placeholder="请输入库存">
                        <template slot="prepend">输入库存</template>
                    </el-input>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-button id="signup" v-on:click="saveBook" style="width:100%" type="success">保存</el-button>
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
            book: {
                isbn:'',
                name:'',
                author:'',
                price:'',
                inventory:''
            }
        }
    },

    methods: {
        saveBook() {
            var data = {
                isbn: this.book.isbn,
                name: this.book.name,
                author: this.book.author,
                price: this.book.price,
                inventory: this.book.inventory
            };
            http
              .post("/book/addNewBook",data)
              .then(response => {
                console.log(response.data)
                if (response.data) {
                    alert('添加成功')
                    location.reload();
                    }
                if (!response.data) {alert('添加失败，该书籍(ISBN)已存在')}
              })
              .catch(e => {
                  console.log(e)
              })
        }
    },
    mounted() {
      const data = JSON.parse(sessionStorage.getItem('login'));
      if (data.ad == 0) {
          alert('您无权限访问本界面')
          this.$router.replace('/')
      }
    },

}
</script>

<style>

</style>
