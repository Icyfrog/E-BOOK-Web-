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
          label="order item ID"
          width="180">
        </el-table-column>

        <el-table-column
          prop="orderId"
          label="order ID"
          width="180">
        </el-table-column>

        <el-table-column
          prop="bookid"
          label="book ID"
          width="180">
        </el-table-column>
        
        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
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
            search: '',
        }
    },
    mounted(){
      var ss = this.$route.params.oid;
      console.log('ss');
      console.log(ss);
      http
        .get('/order/items', {params:{oid:ss}})
        .then(response => {
          console.log('反悔了');
          console.log(response.data);
          this.tableData = response.data
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
    },

}
</script>

<style>

</style>
