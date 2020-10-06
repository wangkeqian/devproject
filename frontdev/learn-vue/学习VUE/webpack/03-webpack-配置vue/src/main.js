require('./css/normal.css');
const {add,mul} = require('./js/mathUtils.js')
import {name,age,height} from './js/info'


import Vue from 'vue'
// import app from './vue/app.js';
import app from './vue/app.vue';

const vm = new Vue({
  el: '#app',
  template: '<app/>',
  components: {
    app
  }

})