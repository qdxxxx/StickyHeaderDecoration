# StickyHeaderDecoration
A sticky header decoration, use for recyclerview
<br/>
 ![image](https://github.com/qdxxxx/StickyHeaderDecoration/blob/master/appGif/GIF.gif)
### 集成方式

 - 注入依赖
Step 1. Add the JitPack repository to your build file
 Step 2. Add the dependency
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
    compile 'com.github.qdxxxx:StickyHeaderDecoration:1.0.1'
}
```
#### Version
---
 - v1.0.1  ： 配合RecyclerView使用的悬浮头部和标题头部，目前支持文字和自定义layout两种头部，LinearLayoutManager【横向】及GridLayoutManager【横向】可用，暂不支持StaggeredGridLayoutManager。



<br/>
