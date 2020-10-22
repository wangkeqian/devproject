<template>
  <div>
    <h3>i'm context template title</h3>
    <h3>i'm context template text</h3>
    <h2>haha {{name}}</h2>
  </div>
</template>

<script>
export default {
  name: 'context',
  data() {
    return {
      name: '测试啥啊测试'
    }
  },
  methods: {},
  components: {}
}
</script>

<style scoped lang="stylus">
</style>
