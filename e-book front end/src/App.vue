<template>
  <div id="app">
    <Head/>
    <router-view></router-view>
  </div>
</template>

<script>
import Head from './components/home/head'
export default {
  name: 'App',
  components:{
    Head
  },
  data() {
    return {
      isRouterAlive: true
    }
  }
}
</script>

<style>

</style>
