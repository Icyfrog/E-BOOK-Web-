<template>
  <div id="app">
    <Head/>
    <router-view/>
  </div>
</template>

<script>
import Head from './components/home/head'
export default {
  name: 'App',
  components:{
    Head
  }
}
</script>

<style>

</style>
