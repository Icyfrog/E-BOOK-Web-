<template>
    <div>
  <el-container>
    <el-container>
      <el-aside width="50px"></el-aside>
      <el-main>
          <el-table class="booktable" 
          :data="tableData.filter(data => !search || data.userEmail.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">

        <el-table-column
          prop="id"
          label="ID"
          width="180">
        </el-table-column>

        <el-table-column
          prop="userEmail"
          label="user email"
          width="180">
        </el-table-column>

        <el-table-column
          prop="orderTime"
          label="下单时间"
          width="180">
        </el-table-column>
        
        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="medium"
            placeholder="输入关键字搜索email"/>
        </template>
        <template slot-scope="scope">
          <el-button type="primary"
            size="medium"
            @click="getInfo(scope.$index, scope.row)">详情信息</el-button>
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
    data(){
        return {
            tableData:[],
            search: '',
        }
    },
    mounted(){
      const data = JSON.parse(sessionStorage.getItem('login'));
      if (data.ad == 0) {
          alert('您无权限访问本界面')
          this.$router.replace('/')
      }
      http
        .get('/order/all')
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

</style>
