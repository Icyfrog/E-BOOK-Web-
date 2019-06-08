# e-book 开发日记     
git push -u origin master


之前三次迭代还好吧...
目前问题蛮多的。RUA

2019/6/8
看了下淘宝  感觉自己之前做的那个tmpcart应该就是 购物车的意思。
然后从购物车里选中物品，下订单，这才是真正的order。
order里会有实际详情，是否取消，是否付款云云。
从cart添加order，在order里从email查找用户，从bookisbn查找书籍，最后总结sum price
但是还是遇到了问题：

怎么在页面返回从其他db里拿到的数据，比如说 由cart里面的bookisbn（这是个FK），怎么从book数据库中得到书名和价格呢？