import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    counter: 4396
  },
  mutations: {
    increase(state){
      state.counter++;
    },
    decrease(state){
      state.counter--;
    }
  },
  actions: {
  },
  modules: {
  }
})
