# FlowLayout
一个可以自动换行的Layout，一般用于tag显示。

1、支持设置横纵向间隙；

2、支持设置横向个数，纵向自适应。

效果如下：

<img src="https://github.com/AWarmHug/FlowLayout/blob/master/screenshots/sample.png?raw=true" width="200px" />

一共三个控件：

<img src="https://github.com/AWarmHug/FlowLayout/blob/master/screenshots/views.png?raw=true" width="200px" />

外部的FlowRadioGroup是直接继承RadioGroup的，修改了onMeasure和onLayout，flow包下的是继承ViewGroup，其实没什么区别。

flow包下的FlowRadioGroup直接复制RadioGroup中的实现。如果是使用flow包下的。需要注意：因为 ((RadioButton) child).setOnCheckedChangeWidgetListener隐藏，只能使用setOnCheckedChangeListener，所以在其他地方不要在使用setOnCheckedChangeListener.

另外，因为是自动换行，所以layout_width，应该给一个确定值match_parent或xxdp。

相关属性：

```
<!--flow包下-->
app:flow_horizontalSize="3"
app:flow_spaceH="8dp"
app:flow_spaceV="8dp"

<!--非flow包下-->
 app:horizontalSize="3"
 app:spaceH="8dp"
 app:spaceV="8dp"

```

使用:

已经放到jitpack.io上，

在项目.gradle中添加maven { url "https://jitpack.io" }

在app.gradle中添加compile 'com.github.AWarmHug:FlowLayout:x.y.z'