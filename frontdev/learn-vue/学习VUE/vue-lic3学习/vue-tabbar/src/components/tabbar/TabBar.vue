<template>
  <div class='tab-bar'>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'TabBar',
  data() {
    return {

    }
  },
  methods: {},
  components: {}
}
</script>

<style scoped>
  @import url('../../assets/css/base.css');
  .tab-bar{
    display: flex;
    background-color: #f6f6f6;
    position: fixed;
    left: 0px;
    right: 0px;
    bottom: 0px;
    box-shadow: 0 -1px 1px rgba(100,100,100,.1);
  }
</style>
