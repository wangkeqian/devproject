//配置路由的信息
import VueRouter from 'vue-router'
import Vue from 'vue'
import Home from '../components/Home'
import About from '../components/About'
import User from '../components/User';

const news = () => import('../components/Home/News.vue')
const messages = () => import('../components/Home/Message.vue')
const profile = () => import('../components/Profile.vue')
//1.通过 Vue.use (plugin) install this VueRouter plugin
Vue.use(VueRouter)
//2.create router object 
//Attention！！！it's routes !!! not's routers
const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    name: '首页',
    component: () => import('../components/Home.vue'),
    meta: {
      title: '首页'
    },
    children: [
      // {
      //   path: '',
      //   component: news
      // },
      {
        path: 'news',
        component: news //不要加'/'
      },
      {
        path: 'messages',
        component: messages
      }
    ]
  },
  {
    path: '/user/:userId',
    component : () => import('../components/User.vue'),
    name: '用户',
    meta: {
      title: '用户'
    }
  },
  {
    path: '/about',
    name: '关于',
    component: () => import('../components/About.vue'),
    meta: {
      title: '关于'
    }
  },
  {
    path: '/profile',
    name: '档案',
    component: profile,
    meta: {
      title: '档案'
    }
  }
]
const router = new VueRouter({
  routes,
  mode: 'history',   //from hash routes mode to history mode
  linkActiveClass: 'active'  //modification active class

})
//前置钩子
router.beforeEach((to,from,next) => {
  document.title = to.matched[0].meta.title
  next()
})
//获取原型对象上的push函数
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
//3. from router obejct to Vue instance
export default router