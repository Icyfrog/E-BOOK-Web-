# e-book 开发日记  还是用txt打开吧

数据库设计
BOOKS表
id    名     价格    

USERS表
id   account      password      role（权限）

Orders表
id		userid

OrderItems表
id	order_id（Orders表外键）	bookid（book表外键）

书评的问题
MongoDB 方便存取图片，书评（tree-树型结构）
适合的数据存在适合的数据库（关系型数据库mysql，非关系型MongoDB)

C R U D
增删改查 写几个Servlet？4个吗？
还是 写一个BookServlet，管理四个业务
根据Usecase图，明显后者更好

2019/6/8
看了下淘宝  感觉自己之前做的那个tmpcart应该就是 购物车的意思。
然后从购物车里选中物品，下订单，这才是真正的order。
order里会有实际详情，是否取消，是否付款云云。
从cart添加order，在order里从email查找用户，从bookisbn查找书籍，最后总结sum price
但是还是遇到了问题：

怎么在页面返回从其他db里拿到的数据，比如说 由cart里面的bookisbn（这是个FK），怎么从book数据库中得到书名和价格呢？




> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
