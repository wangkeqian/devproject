<template>
  <div>
    <h1>档案</h1>
    <h2>{{$route.query}}</h2>
    <ul>
      <li v-for='(item,key,index) in $route.query'>{{key}} : {{item}}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Profile',
  data() {
    return {

    }
  },
  methods: {},
  components: {}
}
</script>

<style scoped>
</style>
