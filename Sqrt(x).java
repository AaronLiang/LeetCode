Sqrt(x) Apr 3 '125014 / 17241
Implement int sqrt(int x).

Compute and return the square root of x.

http://www.codeproject.com/Articles/69941/Best-Square-Root-Method-Algorithm-Function-Precisi
http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html


===========================================================================
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 2) return x;
        int start =0, end;  
        end= x/2 < (int)Math.sqrt(Integer.MAX_VALUE)? x/2+1: (int)Math.sqrt(Integer.MAX_VALUE);  
          while(start<= end)  
          {  
           int mid = (start+end)/2;  
           int sqr = mid*mid;  
           if(sqr ==x)  
            {  
              return mid;  
            }  
            if(sqr<x)  
            {  
              start = mid+1;  
            }  
            else  
            {  
              end = mid-1;  
            }  
          }  
          return (start+end)/2;  
    }  
========================================================================


1. 二分搜索

对于一个非负数n，它的平方根不会小于（n/2+1）。在[0, n/2+1]这个范围内可以进行二分搜索，求出n的平方根。


 1 int sqrt(int x) {
 2     long long i = 0;
 3     long long j = x / 2 + 1;
 4     while (i <= j)
 5     {
 6         long long mid = (i + j) / 2;
 7         long long sq = mid * mid;
 8         if (sq == x) return mid;
 9         else if (sq < x) i = mid + 1;
10         else j = mid - 1;
11     }
12     return j;
13 }

注：在中间过程计算平方的时候可能出现溢出，所以用long long。

2. 牛顿迭代法


   为了方便理解，就先以本题为例：

   计算x2 = n的解，令f(x)=x2-n，相当于求解f(x)=0的解，如左图所示。

   首先取x0，如果x0不是解，做一个经过(x0,f(x0))这个点的切线，与x轴的交点为x1。

   同样的道理，如果x1不是解，做一个经过(x1,f(x1))这个点的切线，与x轴的交点为x2。

   以此类推。

   以这样的方式得到的xi会无限趋近于f(x)=0的解。

   判断xi是否是f(x)=0的解有两种方法：

   一是直接计算f(xi)的值判断是否为0，二是判断前后两个解xi和xi-1是否无限接近。

 

经过(xi, f(xi))这个点的切线方程为f(x) = f(xi) + f’(xi)(x - xi)，其中f'(x)为f(x)的导数，本题中为2x。令切线方程等于0，即可求出xi+1=xi - f(xi) / f'(xi)。

继续化简，xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi = (xi + n/xi) / 2。

有了迭代公式，程序就好写了。关于牛顿迭代法，可以参考wikipedia以及百度百科。


 1 int sqrt(int x) {
 2     if (x == 0) return 0;
 3     double last = 0;
 4     double res = 1;
 5     while (res != last)
 6     {
 7         last = res;
 8         res = (res + x / res) / 2;
 9     }
10     return int(res);
11 }

牛顿迭代法也同样可以用于求解多次方程的解。

P.S. 本题是求解整数的平方根，并且返回值也是整型。在上述代码基础上稍微做修改，就可以同样适用于double（仅限方法2）。


 1 double sqrt(double x) {
 2     if (x == 0) return 0;
 3     double last = 0.0;
 4     double res = 1.0;
 5     while (res != last)
 6     {
 7         last = res;
 8         res = (res + x / res) / 2;
 9     }
