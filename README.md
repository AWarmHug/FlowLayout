# FlowLayout
一个可以自动换行的Layout，一般用于tag显示。

1、支持设置横纵向间隙；

2、支持设置横向个数，纵向自适应。

效果如下：

<img src="https://github.com/AWarmHug/FlowLayout/blob/master/screenshots/sample.png?raw=true" width="200px" />

另外，因为是自动换行，所以layout_width，应该给一个确定值match_parent或xxdp。

相关属性：

```
 app:horizontalSize="3"
 app:spaceH="8dp"
 app:spaceV="8dp"
```

使用:

已经放到jitpack.io上，

在项目.gradle中添加maven { url "https://jitpack.io" }

在app.gradle中添加compile 'com.github.AWarmHug:FlowLayout:x.y.z'

V1.0.4：

修复child设置margin的问题，如果设置了固定horizontalSize，那么子控件会相应移动，如果是左右margin，那么会缩小，如果为设置horizontalSize，那么会移动换行。

其实一般情况下，设置space就已经足够了，但是比如添加CardView时，为了显示阴影，就必须设置margin。