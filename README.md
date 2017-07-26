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
#### Activity里面集成代码
 - 分组头部
```
final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return //返回每个分组头部名称;
            }
        };
```

 - 自定义头部/悬浮头部layout
 ```
decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(int pos) {
                return //返回自定义头部view;
            }
        });
 ```
 
  - 头部点击事件
   ```
        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int pos) {
            }
        });
 ```

   - GridLayoutManager请配合GridDecoration使用。
 
 
	
