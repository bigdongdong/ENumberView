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
	  implementation 'com.github.bigdongdong:ENumberView:1.0.x' //添加依赖
  }
```

# 属性说明
```xml
    xmlns:e_number="http://schemas.android.com/apk/res-auto"
    e_number:count = "8"
    e_number:backgroundColor="#eaeaea"
    e_number:foregroundColor="#111111"
```

|属性名称|解释|
|:---|:---|
|count|数字位数|
|backgroundColor|背景色|
|foregroundColor|前景色|

# 使用说明
```java
	EnumberView eNumberView = findViewById(R.id.eNumberView);
	eNumberView.set(599847);
	
	or:
	eNumberView.set(599847,true); //如果空位需要用'0'填充，第二个参数传true
```
