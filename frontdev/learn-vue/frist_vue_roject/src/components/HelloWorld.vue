<template>
  <div class="hello">
    
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: ''
    }
  },
    mounted() {
    let params = new URLSearchParams();
    params.append('name','wkq')
    params.append('desc','this is goodboy')
      this.$axios.post('/getInfo',params)
      .then(res => {
        this.msg=res.data
      })
      .catch(err => {
        console.error(err); 
      })
    },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
