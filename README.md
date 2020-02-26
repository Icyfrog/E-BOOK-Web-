# e-book 开发日记     
git push -u origin master

REF：
（https://www.cnblogs.com/xdp-gacl/p/3729033.html）
（https://www.cnblogs.com/xdp-gacl/p/3803033.html）
（https://www.cnblogs.com/xdp-gacl/p/3855702.html）
（https://cn.bing.com/search?q=web%E7%99%BB%E5%BD%95%E5%AE%9E%E7%8E%B0&qs=n&form=QBRE&sp=-1&pq=web%E7%99%BB%E5%BD%95+&sc=0-6&sk=&cvid=0A9A7E6F0D9E4F60A0C731A25900BE6E）
（https://www.cnblogs.com/xdp-gacl/p/3902537.html）


之前三次迭代还好吧...
目前问题蛮多的。RUA

2019/6/8
看了下淘宝  感觉自己之前做的那个tmpcart应该就是 购物车的意思。
然后从购物车里选中物品，下订单，这才是真正的order。
order里会有实际详情，是否取消，是否付款云云。
从cart添加order，在order里从email查找用户，从bookisbn查找书籍，最后总结sum price
但是还是遇到了问题：

怎么在页面返回从其他db里拿到的数据，比如说 由cart里面的bookisbn（这是个FK），怎么从book数据库中得到书名和价格呢？
在后端用Bookservice和Cartservice,然后传回前端的东西多一点（具体是什么呢？函数返回类型应该是什么）。感觉像是这个样子。
大概有想法了，就是购物车也做成一个表，然后添加订单的时候把整个购物车传回后端？从购物车里那出信息
from ubuntu
from 2020/2/26
try agagin
