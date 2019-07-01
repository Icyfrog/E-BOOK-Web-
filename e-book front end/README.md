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

2019/6/28
剩两天多开发时间，时间略显紧迫啊
开始搞登录 ———— 

2019/7/1
目前这种，因为isbn不唯一，所以得手动删除一两本书？
1. 登录、查找这种，一般用的是GET请求，前端传入参数一般用
``` 
http
    .get("/user/loginTest",{params:{email:data.email,pwd:data.pwd}})
```
后端接受的话
```
    @GetMapping(path="/loginTest")
    @ResponseBody
    public Integer logIn(String email, String pwd) 
```
注意 用parmas的话，就要保证前后端的参数名称是一样的，都是 email，pwd这种。
2. 怎么确定登录状态？
目前是在前端控制的，sessionStorage

3. MongoDB
安装配置走的是这个 https://blog.csdn.net/congcong68/article/details/44277469
好麻烦啊。。还没怎么用就搞了一上午
a. 书评放在mongodb里，然后detail里面再给体现出来吧
b. 封面最好也能放mongodb里. 用base64存在了Mongodb里，然后前端收到json，再转为图片。不过看
教程都建议用url...


4. 之前前后端穿的数据都是string啊，Book啊这种固定的数据结构，忘了可以传 Json了。 
JavaBean是指一段特殊的Java类，
就是有默然构造方法,只有get,set的方法的java类的对象.

**如果用前端传入的JSON的话，还怎么在service层里面直接啊？**
**感觉还是需要在controller那里写业务逻辑啊**
有个初步想法是，在service层，传入的不是一个json，而是很多很多个
参数，这样再在controller层那里，有json传入，声明变量，获取值，然后调用service，但是这样是不是太麻烦了？

5. 页面之间传参数，相当于 到底是谁登陆了谁买了书
在 推荐书籍和加入我们之间尝试。

6. **问题** 到底要怎么在不更改主键的前提下update数据
   目前我的想法是，先根据isbn判断有没有这个，有的话就删掉，再插入，另外还要考虑外键约束的事情！这个要问别人好好研究研究
   答案是：不要用ISBN作为书的key,不能是unique,就可以了

7. 有关订单处理这一方面，还有个问题是 怎么将不同的类实体组合为JSON，估计会有API可以用？
8. 以及空订单的处理？
9. 明白了service层的另一层意义：不用的controller可以调用多个service
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
