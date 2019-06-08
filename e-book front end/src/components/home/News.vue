<template>
<div>
    <el-container>
        <el-header height="60px">
            <br>
            <div class="NewsTitle">
                <h1>封禁名单</h1>
            </div>
        </el-header>
            <el-main>
                <el-table :data="tableData" style="width: 100%" align="middle">

                    <el-table-column
                        prop="id"
                        label="用户编号"
                        width="280">
                    </el-table-column>

                    <el-table-column
                        prop="email"
                        label="用户账号"
                        width="280">
                    </el-table-column>

                    <el-table-column
                        prop="username"
                        label="用户名"
                        width="280">
                    </el-table-column>  

                </el-table>

            </el-main>
    </el-container>
</div>
</template>

<script>
import http from '../../http-common.js'
export default {
     data() {
        return {
          tableData:[]
        }
      },

      mounted() {
        http
        .get('/user/allLock')
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
  .NewsTitle{
      text-align:center;
      font-size: 40px;
  }
</style>
