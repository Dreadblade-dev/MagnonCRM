import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'Greeting',
      component: () => import('@/views/Greeting'),
      beforeEnter: (to, from, next) => {
        if (!store.getters['auth/isAuthenticated']) {
          return next({
            name: 'SignIn',
          })
        }
        next()
      },
    },
    {
      path: '/person',
      name: 'Person',
      component: () => import('@/views/Person'),
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: () => import('@/views/Auth/SignUp'),
    },
    {
      path: '/signin',
      name: 'SignIn',
      component: () => import('@/views/Auth/SignIn'),
    },
  ],
})
