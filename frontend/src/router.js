import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'Greeting',
      component: () => import('@/views/Greeting'),
    },
    {
      path: '/person',
      name: 'Person',
      component: () => import('@/views/Person')
    }
  ],
})
