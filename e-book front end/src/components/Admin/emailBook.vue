<template>
    <div>
  <el-container>
    <el-container>
      <el-aside width="250px"></el-aside>
      <el-main>
          <el-table class="booktable" 
          :data="tableData"
          style="width: 100%">

        <el-table-column
          prop="name"
          label="书名"
          width="180">
        </el-table-column>

        <el-table-column
          prop="num"
          label="总购买数量"
          width="180">
        </el-table-column>
        
        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope" style="length: 50%">
            <el-button type="danger"
            size="medium"
            @click="check()">查询</el-button>
            <el-input style="width:520px"
            v-model="data.email"
            size="medium"
            placeholder="输入查询账号"/>
          <el-input style="width:520px"
            v-model="data.beginTime"
            size="medium"
            placeholder="输入起始时间"/>
          <el-input style="width:520px"
            v-model="data.endTime"
            size="medium"
            placeholder="输入终止时间"/>
        </template>
        <template slot-scope="scope">
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
            data:{
            beginTime: '2000-01-01 00:00:00',
            endTime:'2100-01-01 00:00:00',
            email:''}
        }
    },
    mounted(){
      const data = JSON.parse(sessionStorage.getItem('login'));
      if (data.ad == 0) {
          alert('您无权限访问本界面')
          this.$router.replace('/')
      }
    },
    methods:{
        check(){
        var data = this.data;
        http
        .post('/order/userBooks', data)
        .then(response => {
         console.log(response.data);
         this.tableData = response.data;
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
        },
    }

}
</script>

<style>

</style>
