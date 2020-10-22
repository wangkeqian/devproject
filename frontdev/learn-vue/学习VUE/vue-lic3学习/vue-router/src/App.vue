<template>
  <div>
    <router-link to="/home" tag='button' replace>首页</router-link>
    <router-link to="/about" tag='button' replace>关于</router-link>
    <!-- <router-link :to="'/user/'+userId" tag='button'  replace >用户</router-link> -->
    <button @click='userClick'>用户</button>
    <button @click='profileClick'>档案</button>
    <!-- <router-link :to='profile' tag='button'  replace >档案</router-link> -->
    <!-- <button @click='homeClick'>首页</button> -->
    <!-- <button @click='aboutClick'>关于</button> -->
    <keep-alive>
      <router-view/>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: 'app',
  data() {
    return {
      userId: '王克千'
    }
  },
  methods: {
    homeClick(){
      // this.$router.push("/home")
      this.$router.replace("/home")
    },
    aboutClick(){
      this.$router.push("/about")
    },
    userClick(){
      this.$router.push('/user/'+this.userId)
    },
    profileClick(){
      this.$router.push({
        path: '/profile',
        query: {
          name: 'jack',
          age: 14,
          height: 1.62
        }
      })
    }
  },
  computed: {
    profile(){
      return {
        path: '/profile',
        query: {
          name: '王克千',
          age: 24,
          height: 1.72
        }
      }
    }
  },
  components: {}
}
</script>

<style scoped>
  .active{
    color: red;
  }
</style>
