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
    </el-col>
    <div class = "upload">
          <el-upload
              ref='upload'
              :auto-upload='false' 
              :file-list="fileList" 
              :multiple='false'
              :limit="1"
              :http-request="uploadFiles" 
              accept="image/jpeg,image/gif,image/png"
              action=''         
              >
            <el-button slot="trigger" size="medium" type="primary">选取图片</el-button>
            <span>&nbsp;</span>
            <el-button @click='uploadFiles' size="medium" type="primary">点击上传</el-button>
          </el-upload>   
    </div>
    </el-row>
        <div class="picture">
            <img :src='ppp' width="300">
        </div>
        <el-button class="alterButton"
            size="medium"
            type="primary"
            @click="alter()">确认更改</el-button>
            <el-button class="deleteButton"
            size="medium"
            type="danger"
            @click="deleteBook()">删除书籍</el-button>
        <br>
  </div>
</template>

<script>
import http from '../../http-common.js'
export default {
    data() {
        return {
            ss:this.$route.params.id,
            bookname:'',
            bookIsbn:'',
            bookauthor:'',
            bookprice:'',
            bookinventory:'',
            bookcomment:'假书要什么书评12123？假书要什么封面',
            ppp:'',
            newbook:{
                id:'',
                name:'',
                isbn:'',
                author:'',
                price:'',
                inventory:'',
                base64:'this.newbo',
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
                  this.$router.replace('/admin/checkbook') 
              }
              else {
                  alert('修改失败');
              }
          })
          .catch(e => {
              console.log(e)
          })
      },
      deleteBook(){
        var data = this.newbook;
        console.log(data)
        http
          .post("/book/deleteBook",data)
          .then(response => {
              console.log(response.data)
              if (response.data) {
                  alert('删除成功');
                  this.$router.replace('/admin/checkbook') 
              }
              else {
                  alert('删除失败失败');
              }
          })
          .catch(e => {
              console.log(e)
          })
      },
      uploadFiles(){
      //var That=this;
      let file=this.$refs.upload.$refs['upload-inner'].$refs.input; //获取文件数据
      let fileList=file.files;  
      console.log('000');
      console.log(fileList[0]);
      console.log('111');
      var imgFile;
      var bookid = this.newbook.id;
      let reader = new FileReader();     //html5读文件
      reader.readAsDataURL(fileList[0]); //转BASE64       
      reader.onload=function(e) {        //读取完毕后调用接口
        imgFile = e.target.result;
        //this.newbook.base64 = imgFile;
        console.log(imgFile);
        console.log('bookid:');
        console.log(bookid); 
        var data = {
          id:bookid,
          base64:imgFile
        }
        http
          .post('/book/setpic',data)
          .then(response => {
            console.log(response.data);
            if (response.data) {alert('封面上传成功'); location.reload();}
            else {
              alert('封面上传失败')
            }
          })
      };
    },

    },
    
    mounted() {
      var ss = this.$route.params.id;
      http
        .get('/book/detail', {params:{id:ss}})
        .then(response => {
          console.log(response.data)
          this.bookname = response.data.name;
          this.bookIsbn = response.data.iSBN;
          this.bookauthor = response.data.author;
          this.bookprice = response.data.price;
          this.bookinventory = response.data.inventory;
          this.newbook.id = response.data.id;
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
    left: 330px;
    top: 420px;
  }
  .alterButton {
    position: absolute;
    left: 910px;
    top: 470px;
  }
  .deleteButton {
    position: absolute;
    left: 900px;
    top: 520px;
  }
  .upload {
    position: absolute;
    left: 900px;
    top: 20px;
  }
</style> 
