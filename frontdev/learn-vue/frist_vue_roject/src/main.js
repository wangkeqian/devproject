// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
// import VueAxios from 'vue-axios'
// import $ from 'jquery'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.min.js';
Vue.prototype.$axios = axios;


Vue.config.productionTip = false
/* 解决跨域问题*/
axios.defaults.baseURL = 'api'


/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})
