import Vue from 'vue'
import Router from 'vue-router'
import first from '@/components/first'
import Reco from '@/components/home/Reco'
import News from '@/components/home/News'
import Joinus from '@/components/home/Joinus'
import Cart from '@/components/cart/Cart'
import User from '@/components/User/User'
import Login from '@/components/login/Login'
import Signup from '@/components/login/Signup'
import Detail from '@/components/detail/bookDetail'
import UserList from '@/components/Admin/UserList'
import AddNewBook from '@/components/Admin/AddNewBook'
import CheckBook from '@/components/Admin/CheckBook'
import AlterBook from '@/components/Admin/AlterBook'
import Order from '@/components/order/Order'

Vue.use(Router)

export default new Router({
  routes: [{        /* 最终应该是默认url是登录界面，目前默认是图书页面*/
      path: '/',    /* 登录页面是/login  注册界面signup*/
      name: 'FirstDemo',      
      component: first
    },
    {
      path:'/login',
      component:Login
    },
    {
      path:'/signup',
      component:Signup
    },
    {
      path: '/reco',
      name: 'recommended books',
      component: Reco
    },
    {
      path: '/news',
      name: 'news',
      component: News
    },
    {
      path: '/joinus',
      name: 'join us',
      component: Joinus
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart
    },
    {
      path: '/users',
      name: 'user',
      component: User
    },
    {
      path:'/admin/UserList',
      name: 'UserList',
      component: UserList
    },
    {
      path:'/admin/AddNewBook',
      name:'AddNewBook',
      component: AddNewBook
    },
    {
      path:'/order',
      name:'order',
      component: Order
    },
    {
      path:'/admin/CheckBook',
      name:CheckBook,
      component:CheckBook
    },
    {
      path:'/admin/AlterBook/:isbn',
      name:AlterBook,
      component:AlterBook
    },
    {
      path: '/list-detail/:isbn',
      name: 'detail',
      component: Detail
    },
  ]
})
