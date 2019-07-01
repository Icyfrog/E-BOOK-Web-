<template>
    <div>
  <el-container>
    <el-container>
      <el-aside width="110px"></el-aside>
      <el-main>
          <el-table class="booktable" 
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">

        <el-table-column
          prop="id"
          label="ID"
          width="180">
        </el-table-column>

        <el-table-column
          prop="name"
          label="书名"
          width="180">
        </el-table-column>

        <el-table-column
          prop="author"
          label="作者"
          width="180">
        </el-table-column>

        <el-table-column
          prop="price"
          label="价格 /￥"
          width="180">
        </el-table-column>

          <el-table-column
          prop="isbn"
          label="ISBN编号"
          width="180">
        </el-table-column>

          <el-table-column
          prop="inventory"
          label="库存">
        </el-table-column>

        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="medium"
            placeholder="输入关键字搜索"/>
        </template>

        <template slot-scope="scope">
          <el-button type="primary"
            size="medium"
            @click="getInfo(scope.$index, scope.row)">更改信息</el-button>
        </template>

      </el-table-column>
      </el-table>
      </el-main>
    </el-container>
  </el-container>

    </div>
</template>

<script>
import http from '../../http-common.js'
export default {
    //inject: ['reload'],
     data() {
        return {
            tableData:[],
            search: '',
            order: {
              orderuseremail:'',
              orderisbn:''
            }
      }
    },
    methods: {
      getInfo(index,row) {      // 函数，还未实现
        console.log(index,row);
        this.$router.replace('/admin/AlterBook/'+row.id);
      },
    },
    mounted() {
      const data = JSON.parse(sessionStorage.getItem('login'));
      if (data.ad == 0) {
          alert('您无权限访问本界面')
          this.$router.replace('/')
      }
      http
        .get('/book/all')
        .then(response => {
          this.tableData = response.data
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
  .booktable{
      background-color: black;
  }
</style>
