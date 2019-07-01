<template>
  <div>
    <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">书名</div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">{{bookname}}</div></el-col>
    </el-row>
    <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">作者</div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">{{bookauthor}}</div></el-col>
    </el-row>
    <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">价格</div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">￥{{bookprice}}</div></el-col>
    </el-row>
    <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">剩余库存</div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">{{bookinventory}}</div></el-col>
    </el-row>
    <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">书评</div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">{{bookcomment}}</div></el-col>
    </el-row>
    <div class="picture">
          <img :src='ppp' width="300">
        </div>
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
            bookauthor:'',
            bookprice:'',
            bookinventory:'',
            bookcomment:'假书要什么书评？假书要什么封面',
            ppp:''
        }
    },
    methods: {
      addOrder(){
        console.log(this.book)
        console.log("等着加入购物车哈")
      }
    },
    mounted() {
      var ss = this.$route.params.id;
      http
        .get('/book/detail', {params:{id:ss}})
        .then(response => {
          console.log(response.data)
          this.bookname = response.data.name;
          this.bookauthor=response.data.author;
          this.bookprice=response.data.price;
          this.bookinventory=response.data.inventory;
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
        http 
          .get('/book/comment',{params:{id:ss}})
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
    left: 30px;
    top: 320px;
  }
  .button {
    position: absolute;
    left: 530px;
    top: 320px;
  }
</style> 
