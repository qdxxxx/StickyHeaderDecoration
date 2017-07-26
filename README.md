# StickyHeaderDecoration
A sticky header decoration, use for recyclerview，when use GridLayoutManager auto set group`s span.
<br/>
 ![image](https://github.com/qdxxxx/StickyHeaderDecoration/blob/master/appGif/GIF.gif)
 天气热，本github已安装空调，star即可免费享用~~
 
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
        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return //返回每个分组头部名称;
            }
        };
```

 - 自定义头部/悬浮头部layout【自定义头部加载图片请用 ```loadImage() ```方法】
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
 

#### GridLayoutManager请配合GridDecoration使用。
 
 ### 方法及属性介绍
---

name                   | format         |中文解释
----                   |------      	|----
setHeaderHeight        | integer    	|分组头部高度
setTextPaddingLeft     | integer   	|普通分组头部【只含文字】文字左边距
setTextSize            | integer	|普通分组头部【只含文字】文字大小
setTextColor           | integer 	|普通分组头部【只含文字】文字颜色
setHeaderContentColor  | integer  	|普通分组头部【只含文字】文字背景颜色
onDestory	       |                |清空数据集合/监听等
*loadImage              |String,integer,ImageView|用来加载并刷新图片到分组头部【自定义头部很重要的方法！】


####  License
---

```
MIT License

Copyright (c) 2017 qdx

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
