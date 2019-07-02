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
            <el-button type="primary"
            size="medium"
            @click="jump()">账号查询</el-button>
            <el-button type="danger"
            size="medium"
            @click="check()">限时查询</el-button>
          <el-input style="width:520px"
            v-model="beginTime"
            size="medium"
            placeholder="输入起始时间"/>
          <el-input style="width:520px"
            v-model="endTime"
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
            beginTime: '2000-01-01 00:00:00',
            endTime:'2020-01-01 00:00:00',
        }
    },
    mounted(){
      const data = JSON.parse(sessionStorage.getItem('login'));
      if (data.ad == 0) {
          alert('您无权限访问本界面')
          this.$router.replace('/')
      }
      http
        .get('/order/totalBooks', {params:{beginTime:'2000-07-02 15:44:07', endTime:'2999-07-02 15:44:07'}})
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
    methods:{
        check(){
        http
        .get('/order/totalBooks', {params:{beginTime:this.beginTime, endTime:this.endTime}})
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
        jump(){
            this.$router.replace('/admin/emailBook')
        }
    }

}
</script>

<style>

</style>
