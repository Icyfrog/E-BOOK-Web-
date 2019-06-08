<template>
    <div>

        <div class="cart">
               
        </div>
        <div class="cart">
            购物车
        </div>
    <el-container>
      <el-aside width="150px"></el-aside>
      <el-main>
          <el-table class="booktable" 
          :data="tableData.filter(data => !search || data.title.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">
        <el-table-column
          prop="title"
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
          label="单价 /￥"
          width="180">
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope">
          <el-button type="primary"
            size="medium"
            @click="handleEdit(scope.$index, scope.row)">+</el-button>
          </template>
        </el-table-column>
          <el-table-column
          prop="num"
          label="数量">
        </el-table-column>
        <el-table-column>
                <template slot-scope="scope">
          <el-button
            size="medium"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">-</el-button>
                </template>
        </el-table-column>
        <el-table-column align="right"
          prop="sum"
          label="总价 /￥"
          width="180">
        </el-table-column>
        <el-table-column>
      </el-table-column>
      </el-table>
      </el-main>
    </el-container>
  </el-container>
      <div id="SUM">
        总金额：{{729.4}} ￥   这里应该用{{}}&nbsp&nbsp&nbsp&nbsp&nbsp
    </div>
    <div align="middle">
    <el-button
            size="medium"
            type="primary"
            @click="submitCart">提交订单</el-button>
    </div>
    <br>
    <div align="middle">
    <el-button
            size="medium"
            type="danger"
            @click="cancelCart">取消订单  把上面的数量全都清空</el-button>
    </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
          tableData: [{
            title: '流浪地球',
            author: '刘慈欣',
            price: '18.20',
            num: '1',
            sum:'18.20'
          }, {
            title: '光荣与梦想',
            author: '威廉 · 曼彻斯特',
            price: '149.10',
            num: '2',
            sum:'149.10'
          }, {
            title: '百年孤独',
            author: '加西亚 · 马尔克斯',
            price: '41.30',
            num: '10',
            sum:'423.00'
          },
          ]
      }
    },
    methods: {
      handleEdit(index, row) {      // 函数，还未实现
        console.log(index, row);
      },
      handleDelete(index, row) {    // 函数，还未实现
        console.log(index, row);
      }
    },
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
