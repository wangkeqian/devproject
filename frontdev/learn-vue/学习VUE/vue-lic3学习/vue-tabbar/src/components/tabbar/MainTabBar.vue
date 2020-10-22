<template>
  <div>
    <tab-bar>
      <tab-bar-item path='/home' >
        <img slot='item-icon' src="@/assets/img/tabbar/shouye.svg" alt="">
        <img slot='item-icon-active' src="@/assets/img/tabbar/shouye-active.svg" alt="">
        <div>首页</div>
      </tab-bar-item>
      <tab-bar-item path='/category'>
        <img slot='item-icon' src="@/assets/img/tabbar/fenlei.svg" alt="">
        <img slot='item-icon-active' src="@/assets/img/tabbar/fenlei-active.svg" alt="">
        <div>分类</div>
      </tab-bar-item>
      <tab-bar-item path='/shopcart' >
        <img slot='item-icon' src="@/assets/img/tabbar/shop.svg" alt="">
        <img slot='item-icon-active' src="@/assets/img/tabbar/shop-active.svg" alt="">
        <div>购物车</div>
      </tab-bar-item>
      <tab-bar-item path='profile'>
        <img slot='item-icon' src="@/assets/img/tabbar/wode.svg" alt="">
        <img slot='item-icon-active' src="@/assets/img/tabbar/wode-active.svg" alt="">
        <div>我的</div>
      </tab-bar-item>
    </tab-bar>
    <router-view></router-view>
  </div>
</template>

<script>
  import TabBar from './TabBar.vue'
  import TabBarItem from './TabBarItem.vue'
  export default {
    name: 'MainTabBar',
    data() {
      return {

      }
    },
    methods: {},
    components: {
      TabBar,
      TabBarItem
    }
  }
</script>

<style scoped>
</style>
