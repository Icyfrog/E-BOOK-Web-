<template>
    <div>
        <p>来了就是想要，犹豫就是想买</p>
        <h3>待美化</h3>
        <br>
        <p>书名:{{book.name}}</p>
        <p>作者：{{book.author}}</p>
        <p>价格：￥{{book.price}}</p>
        <p>剩余库存：{{book.inventory}}</p>
        <br>
        <el-button
            size="medium"
            type="danger"
            @click="addOrder">加入购物车</el-button>
    </div>
</template>

<script>
import http from '../../http-common.js'
export default {
    data() {
        return {
            ss:this.$route.params.isbn,
            book:[]
        }
    },
    methods: {
      addOrder(){
        console.log(this.book)
        console.log("等着加入购物车哈")
      }
    },
    mounted() {
      var ss = this.$route.params.isbn;
      http
        .get('/book/detail', {params:{isbn:ss}})
        .then(response => {
          console.log(response.data)
          this.book = response.data
        })
        .finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
    }
    
    /*
    mounted() {
        var ss = this.$route.params.isbn;
        console.log(ss);
        http
          .get("/book/detail", ss)
          .then(response => {
            console.log(response.data)
          this.tableData = response.data
        })
        .catch(e => {
          console.log(e)
        })
    }
    */
}
</script>

<style>

</style> 
