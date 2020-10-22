<template>
  <div>
    <h1>it's Home Page</h1>
    <h3>it's Home context haha</h3>
    <hr>
    <router-link to="/home/news" tag='button'>News</router-link>
    <router-link to="/home/messages" tag='button'>Messages</router-link>
    <router-view></router-view> 
  </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      path: '/home/news'
    }
  },
  methods: {},
  components: {},
  //when activted or beforeleave to record navigation path 
  //   ,next return use the status recover page

  // activted() 和 deactivated() 是要在App.vue的 router-link 标签被 keep-alive包裹时才有效果
  activated() {
    this.$router.push(this.path)
  },
  beforeRouteLeave (to, from, next) {
    this.path = this.$route.path;
    next()
  }
}
</script>

<style scoped lang="stylus">
</style>
