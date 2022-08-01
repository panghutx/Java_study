### 功能分析

#### 数据库设计：

**评论表**

得分  位置  评价  是否匿名

**商家表**

位置   店铺名   得分  推荐数

**用户表**

用户名    密码    头像   评论历史

#### 页面设计：

主页面：导航、评论表、排行榜、留言板

查询页面：

查评论

查商家

按评分查询  按位置查询



### 遇到的问题

* 如何取消点击事件，加载页面后自动得到数据库数据？

使用钩子函数created(),在里面调用getJson方法

![image-20220716152816611](C:\Users\panghutx\AppData\Roaming\Typora\typora-user-images\image-20220716152816611.png)

* 如何获取select选中了哪一个option

为select添加动态绑定和change事件

为option添加value值，value值为对象id

因为select获取的就是option的value值

![image-20220716153238784](C:\Users\panghutx\AppData\Roaming\Typora\typora-user-images\image-20220716153238784.png)

![image-20220716153311651](C:\Users\panghutx\AppData\Roaming\Typora\typora-user-images\image-20220716153311651.png)

* 模糊匹配问题

%梅%

![image-20220716162529312](C:\Users\panghutx\AppData\Roaming\Typora\typora-user-images\image-20220716162529312.png)