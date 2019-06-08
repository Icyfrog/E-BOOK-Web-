// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import axios from 'axios';
import App from './App';
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

/* css & iconfont */
import './assets/css/reset.css';
import './assets/css/iconfont.css';
/* use axios */
Vue.prototype.$axios = axios;
/* element.UI */
Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
