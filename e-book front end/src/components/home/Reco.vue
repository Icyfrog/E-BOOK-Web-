<template>
    <div>
        <h1 id="reco">推荐图书</h1>
  <el-container>
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
          label="价格 /￥"
          width="180">
        </el-table-column>
          <el-table-column
          prop="isbn"
          label="ISBN编号"
          width="180">
        </el-table-column>
        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="medium"
            placeholder="输入关键字搜索"/>
        </template>
      </el-table-column>
      </el-table>
      </el-main>
    </el-container>
  </el-container>

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
            isbn: '978-7-5470-4315-8',
          }, {
            title: '光荣与梦想',
            author: '威廉 · 曼彻斯特',
            price: '149.10',
            isbn: '978-7-5086-4999-3',
          }, {
            title: '百年孤独',
            author: '加西亚 · 马尔克斯',
            price: '41.30',
            isbn: '978-0-1411-8499-9',
          },
          {
            title: '深入理解计算机系统',
            author: '兰德尔 · E · 布莱恩特',
            price: '239.00',
            isbn: '978-7-111-56127-9',
          },
          ],
          search: '',
          //const orderDataA :{'email':'1@qq.com','id':1},
      }
    },
    mounted() {
      const dataA = {'email':'1@qq.com','id':1};
      sessionStorage.setItem('test1',JSON.stringify(dataA));
    }
  }
</script>

<style>
  .booktable{
      background-color: black;
  }
  #reco{
      text-align: center;
      font-size: 40px;
  }
</style>
