# WelcomeAnimal
之前论坛有人发过一个小红书的导航源码，我看了一下源码构造。
发现解构是很多自定义控件+自定义控件+自定义控件（viewpage嵌套viewpage嵌套viewpage）
使用Frame进行管理，触摸事件触发不断的切换页面。这就导致整个导航页面是一个比较死的结构，
你必须使用他的结构，只能修改里面页面的图标，背景图片，文字，其他都不能动。
不过这个作者的控件是很酷的！这是必须的@w446108264
===============================================
帖子：http://www.eoeandroid.com/thread-568120-1-3.html
github：https://github.com/w446108264/XhsWelcomeAnim
===============================================


所以我分析了一下代码，将一个动画提取了出来，做成了单独库
这是代码：
        /**
         * rl_parent 出现的布局
         * iv_logo 变小的图片
         */
      new AnimalUtul(this,rl_parent,iv_logo);
复制代码


实现的效果（作者，我直接拿你素材）：

![1](https://github.com/01100044093/WelcomeAnimal/blob/master/180740m5tltngagntksunn.gif)

个人优化后效果

![1](https://github.com/01100044093/WelcomeAnimal/blob/master/180752jpf0p5404f54116v.gif)
