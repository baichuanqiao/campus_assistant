# campus_assistant 
这是移动开发课程的Android项目，使用Bmob云后端提供诸如注册、登录、数据保存等服务，项目中联系使用了RxJava来处理异步任务，Logger作为调试日志工具，ORM框架使用GreenDAO。
# 更新日志
* 17/2/18：完成了部分的UI设计并且接入bmob后端云，完成注册登录逻辑，测试了bmob与greendao的配合。
* 17/2/19: 使用自定义view来实现tab渐变切换，完成了ViewPager+Fragment+TabView的切换，在Fragment中接入了LRecyclerView。
* 17/2/21: 完成了剩余Fragment的UI设计，查阅官网关于bmob的数据存储和查找介绍，准备编写剩下Fragment的逻辑代码。

# 依赖列表：
```bash
//一些支持库
compile 'com.android.support:appcompat-v7:24.2.0'
compile 'com.android.support:design:24.2.0'
compile 'com.android.support:recyclerview-v7:24.2.0'
compile 'com.android.support:cardview-v7:24.2.0'
compile 'com.android.support:support-v4:24.2.0'
//一个好用的RecycleView封装
compile 'com.github.jdsjlzx:LRecyclerView:1.0.9'
//view注入框架
compile 'com.jakewharton:butterknife:8.4.0'
//ORM框架
compile 'org.greenrobot:greendao:3.0.1'
//日志
compile 'com.orhanobut:logger:1.15'
//实际没用使用的EventBus
compile 'org.greenrobot:eventbus:3.0.0'
//bmob后端云
compile 'cn.bmob.android:bmob-sdk:3.5.0'
```
