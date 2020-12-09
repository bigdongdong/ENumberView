# ENumberView
电子数字View


# 截图预览（Screen Recrod）
<img  width = "450" src = "https://github.com/bigdongdong/ENumberView/blob/master/preview/1.jpg"></img></br>

# 项目配置

```
  allprojects {
      repositories {
          ...
          maven { url 'https://jitpack.io' }  //添加jitpack仓库
      }
  }
  
  dependencies {
	  implementation 'com.github.bigdongdong:ENumberView:1.1' //添加依赖
  }
```

# 属性说明
```xml
    <com.cxd.enumberview.ENumberView
            android:id="@+id/eNumberView"
            xmlns:e_number="http://schemas.android.com/apk/res-auto"
            e_number:count="8"
            e_number:backgroundColor="#eaeaea"
            e_number:foregroundColor="#111111"
            android:layout_width="300dp"
            android:layout_height="wrap_content"/>
```

|属性名称|解释|
|:---|:---|
|e_number:count|数字位数|
|e_number:backgroundColor|背景色|
|e_number:foregroundColor|前景色|

# 使用说明
```java
	EnumberView eNumberView = findViewById(R.id.eNumberView);
	eNumberView.set(599847);
	
	or:
	eNumberView.set(599847,true); //如果空位需要用'0'填充，第二个参数传true
```
