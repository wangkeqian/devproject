<template>
  <div>
    <h2>it's {{userId}} interface</h2>
    <h3>it's {{userId}} detail info</h3>
  </div>
</template>

<script>
export default {
  name: 'User',
  data() {
    return {

    }
  },
  computed:{
    userId(){
      return this.$route.params.userId;  //attention!!! $route $route $route
    }
  },
  methods: {},
  components: {}
}
</script>

<style scoped>
</style>
