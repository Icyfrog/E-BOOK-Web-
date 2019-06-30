<template>
  <div>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">书名</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">{{bookname}}</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.name" placeholder="请输入书名">
            <template slot="prepend">输入书名</template>
        </el-input> 
    </el-col>
    </el-row>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">ISBN</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">{{bookIsbn}}</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.isbn" placeholder="请输入ISBN">
            <template slot="prepend">输入ISBN</template>
        </el-input> 
    </el-col>
    </el-row>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">作者</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">{{bookauthor}}</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.author" placeholder="请输入作者">
            <template slot="prepend">输入作者</template>
        </el-input> 
    </el-col>
    </el-row>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">价格</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">￥{{bookprice}}</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.price" placeholder="请输入价格">
            <template slot="prepend">输入价格/￥</template>
        </el-input> 
    </el-col>
    </el-row>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">剩余库存</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">{{bookinventory}}</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.inventory" placeholder="请输入库存">
            <template slot="prepend">输入库存</template>
        </el-input> 
    </el-col>
    </el-row>
    <el-row>
    <el-col :span="4"><div class="grid-content bg-purple">封面</div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple-light">如下图</div></el-col>
    <el-col :span="8">
        <el-input  v-model="newbook.base64" placeholder="请输入base64">
            <template slot="prepend">输入图片base64位码</template>
        </el-input> 
    </el-col>
    </el-row>
        <div class="picture">
            <img :src='ppp' width="300">
        </div>
        <el-button class="alterButton"
            size="medium"
            type="danger"
            @click="alter()">确认更改</el-button>
        <br>
  </div>
</template>

<script>
import http from '../../http-common.js'
export default {
    data() {
        return {
            ss:this.$route.params.isbn,
            bookname:'',
            bookIsbn:'',
            bookauthor:'',
            bookprice:'',
            bookinventory:'',
            bookcomment:'假书要什么书评12123？假书要什么封面',
            ppp:'',
            newbook:{
                name:'',
                isbn:'',
                author:'',
                price:'',
                inventory:'',
                base64:'this.newbook.this.newbook.this.newbook.this.newbook.this.newbook.this.newbook.this.newbook.this.newbook.',
            }
        }
    },
    methods: {
      alter(){
        var data = this.newbook;
        console.log(data)
        http
          .post("/book/alterBook",data)
          .then(response => {
              console.log(response.data)
              if (response.data) {
                  alert('除了封面之外修改成功');
                  location.reload();
              }
              else {
                  alert('修改失败');
              }
          })
          .catch(e => {
              console.log(e)
          })
      }
    },
    mounted() {
      var ss = this.$route.params.isbn;
      http
        .get('/book/detail', {params:{isbn:ss}})
        .then(response => {
          console.log(response.data)
          this.bookname = response.data.name;
          this.bookIsbn = response.data.iSBN;
          this.bookauthor = response.data.author;
          this.bookprice = response.data.price;
          this.bookinventory = response.data.inventory;
          this.newbook.name = response.data.name;
          this.newbook.isbn = response.data.iSBN;
          this.newbook.author = response.data.author;
          this.newbook.price = response.data.price;
          this.newbook.inventory = response.data.inventory;
          this.newbook.base64 = response.data.base64;
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
        http 
          .get('/book/comment',{params:{isbn:ss}})
          .then(response => {
            console.log(response.data)
            this.bookcomment = response.data.comment;
            this.ppp = response.data.base64;
          })
          .finally(() => {
            this.loading = false
          })
          .catch(e => {
            console.log(e)
          })
        }
    }
    
</script>

<style>
.el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .picture {
    position: absolute;
    left: 330px;
    top: 420px;
  }
  .alterButton {
    position: absolute;
    left: 700px;
    top: 420px;
  }
</style> 
