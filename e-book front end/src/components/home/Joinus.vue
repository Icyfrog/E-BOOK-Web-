<template>
    <div>
        Just a joke.
        <p>This page is used to test the front end.</p>
        <p>前端参数传递测试：{{email}}</p>
        <p>前端参数传递测试：id  {{id}}</p>
        <p>前端参数传递测试：管理员  {{ad}}</p>        
    </div>
</template>

<script>
export default {
     data() {
        return {
          email:'default',
          id:'default'
        }
      },
      mounted() {
          const dataB = JSON.parse(sessionStorage.getItem('login'));
          this.email = dataB.email;
          this.id = dataB.id
          this.ad = dataB.ad
      }
}
</script>

<style>

</style>
