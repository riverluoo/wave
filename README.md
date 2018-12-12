## 波峰波谷计算

投影曲线实际上是一个一维的向量

~~~
V = [v1,v2,...,vn]
~~~

其中vi,i∈[1,2,…,N],代表图像在第i行或列上的灰度累积。
当然不仅仅是投影曲线，V也可以是某一事件中变量的观测值，我们需要研究这个变量的变化规律。

* 1 假投影曲线可以表示为
~~~
V = [v1,v2,...,vn]
~~~

* 2 计算V的一阶差分向量Diff
~~~
Diff(i)=V(i+1)−V(i),其中i∈1,2,…,N−1
~~~

* 3 对差分向量进行取符号函数运算

Trend=sign(Diffv),遍历Diffv ,若Diffv(i)大于0,则取1；如果小于0，则取-1，否则则值为0

<div align="left"> <img src="https://riverluooo.oss-cn-beijing.aliyuncs.com/img/20181212191147.png" width="400"/> </div><br>

* 4 从尾部遍历Trend向量,进行如下操作
~~~
if Trend(i)=0且Trend(i+1)≥0，则Trend(i)=1
if Trend(i)=0且Trend(i+1)<0，则Trend(i)=−1
~~~

* 5 对Trend向量进行一阶差分运算，如同步骤2，得到R=diff(Trend)

* 6 遍历得到的差分向量R
  如果R(i)=−2，则i+1为投影向量V 的一个波峰值位,对应的波峰值为V(i+1)
  如果R(i)=2，则i+1为投影向量V 的一个波谷位,对应的波谷值为V(i+1)
  
