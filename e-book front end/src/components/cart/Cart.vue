<template>
    <div>
        <el-container>
            <el-container>
            <el-aside width="350px"></el-aside>
            <el-main>
                <el-table class="booktable" 
                :data="tableData.filter(data => !search || data.email.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%">


                    <el-table-column
                    prop="bookisbn"
                    label="ISBN"
                    width="180">
                    </el-table-column>

                    <el-table-column
                    prop="bookprice"
                    label="price/￥"
                    width="180">
                    </el-table-column>

                    <el-table-column
                align="right">
                <template slot-scope="scope">
                <el-button
                    size="medium"
                    type="primary"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
            </el-table>
            <el-button class = "clean" type="danger"
               size="medium"
               @click="clean()">清空购物车</el-button>
            </el-main>
            <el-aside width="350px"></el-aside>
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
      handleDelete(index, row) {    // 函数，还未实现
        console.log(index, row);
        http
          .post("/delete",row.id)
        location.reload();
      },
      clean() {
        var data = this.tableData;
          http
          .post("/order/clean",data)
          .then(response => {
            if(response.data == "ss") {
              alert("虽然你没付钱，但是购买成功了")
              location.reload();
            }
            else {
              var info = "对不起, 书籍：" + response.data.isbn + "库存不足";
              alert(info);
              location.reload();
            }
          })
      }
    },
    mounted() {
      const dataC = JSON.parse(sessionStorage.getItem('login'));
      http
        .get('/cart',{params:{email:dataC.email}})
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
.clean{
  position: absolute;
    left: 1070px;
}
</style>
