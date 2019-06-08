<template>
    <div>
        <el-container>
            <el-container>
            <el-aside width="150px"></el-aside>
            <el-main>
                <el-table class="booktable" 
                :data="tableData.filter(data => !search || data.email.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%">
                    <el-table-column
                    prop="id"
                    label="ID"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="orderuseremail"
                    label="useremail"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="orderisbn"
                    label="BookIsbn"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="paid"
                    label="是否付款"
                    width="180">
                    </el-table-column>
                    <el-table-column
                align="right">
                <template slot-scope="scope">
                <el-button type="danger"
                    size="medium"
                    @click="handleBuy(scope.$index, scope.row)">购买</el-button>
                <el-button
                    size="medium"
                    type="primary"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
import { constants } from 'fs';
export default {
    data() {
        return {
          tableData: [],
      }
    },

    methods: {
      handleBuy(index, row) {      // 函数，还未实现
        console.log(index, row);
        http 
          .post("/buy", row.id)
        location.reload();
      },
      handleDelete(index, row) {    // 函数，还未实现
        console.log(index, row);
        http
          .post("/delete",row.id)
        location.reload();
      }
    },

    mounted() {
      http
        .get('/cart')
        .then(response => {
          this.tableData = response.data
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
</script>

<style>
.cart{
    text-align:center;
    height:50px;
    font-size: 40px;
}
#SUM{
    text-align:right;
}
</style>
