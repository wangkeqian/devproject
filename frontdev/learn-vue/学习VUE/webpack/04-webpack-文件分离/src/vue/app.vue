<template>
  <div>
    <h1 class='title'>{{name}}</h1>
    <button @click=btnClick >按aaa钮</button>
    <h2>{{massage}}</h2>
    <hr>
    <context></context>
  </div>
</template>

<script>
  import context from './context'
  export default{
    name: 'app',
    data() {
      return {
        name: 'wangkeqian',
        massage: 'hello webpack'
      }
    },
    methods: {
      btnClick(){
        console.log('click event');
        
      }
    },
    components: {
      context
    }
  }
</script>
<style scoped>
  .title{
    color: red;
  }
</style>