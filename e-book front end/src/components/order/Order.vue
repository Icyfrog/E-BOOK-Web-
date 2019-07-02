<template>
    <div>
  <el-container>
    <el-container>
      <el-aside width="50px"></el-aside>
      <el-main>
          <el-table class="booktable" 
          :data="tableData"
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
        <template slot="header" slot-scope="scope" style="length: 50%">
            <el-button type="danger"
            size="medium"
            @click="check()">查询时间</el-button>
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
            beginTime: '',
            endTime:'',
        }
    },
    mounted(){
      const data = JSON.parse(sessionStorage.getItem('login'));
      http
        .get('/order/some', {params:{email:data.email}})
        .then(response => {
          this.tableData = response.data
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
    },
    methods: {
      getInfo(index,row) {
        console.log(index,row);
        this.$router.replace('/items/'+row.id);
      },
      check() {
          var begin = this.beginTime;
          var end = this.endTime;
          console.log(begin);
          for(var ele in this.tableData) {
              console.log(ele.orderTime);
          }
      }
    }

}
</script>

<style>

</style>
