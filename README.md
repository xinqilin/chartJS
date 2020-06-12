# chartJS

```
reference: 
https://www.chartjs.org/
http://www.chartjs.org/docs/latest/

與HY-KM

```

### 引入JS檔

```java

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="PATH" value="${pageContext.request.contextPath}"/>

<script src="${PATH}/js/jquery/jquery-1.12.4.min.js"></script>
<script src="${PATH}/js/chart/Chart.min.js" type="text/javascript"></script>
```

### 引入canvas  & 使用

```js

<canvas id="myChart"></canvas>

var ctx = document.getElementById('myChart').getContext('2d');
```


```js

var chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [{
            label: "My First dataset",
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: [0, 10, 5, 2, 20, 30, 45],
        }]
    },

    options: {}
});
```


### 塞資料

```json
{
    "xBar": [
        "一月",
        "二月",
        "三月",
        "四月",
        "五月",
        "六月"
    ],
    "estimate": [
        600,
        1200,
        1800,
        2400,
        3000,
        3600
    ],
    "actual": [
        800,
        1000,
        1200,
        3000,
        3800,
        4600
    ]
}

```

### 設定好function

```js
/** 
  * chart 圖形物件
  * ctx 取得的canvas
  * type 顯示類別
  * data 資料格式，如標題，格式，顏色等
  * option 圖形的設定檔
  */
 function createChart(chart, ctx, type, data, options){
  //如果畫面上有圖需要destroy舊的圖形重新畫新的
  if(chart != null){
   chart.destroy();
  }
  
  chart = new Chart(ctx, {
         type: type,
         data: data,
         options: options
       });
  return chart;
 }

```

```js
//將資料整理並且畫圖
 var bindData = function (xBar ,estimate, actual){
  var data = {
           labels: xBar,
           datasets: [
             {
               label: "預算金額(元)",
               data: estimate,
               borderColor: "rgba(256,0,0,1)",
               lineTension: 0
             }, {
               label: "實際金額(元)",
               data: actual,
               borderColor: "rgba(0,0,256,1)",
               lineTension: 0
             }
           ]
         };
        
  var  options = {
         animation: {
             duration: 1000, // 生成圖形的時間
          }
   }
  //產出圖形
  myChart = createChart(myChart, ctx, 'line', data, options);
  
    }

```

```js
$('#selectBtn').click(function(){
  
  var type = $('#contractType').val();
  $.post({
   url: '${PATH}/budget.do',
   data : {'type' : type},
   dataType: "json",
   success: function(data){
    bindData(data.xBar, data.estimate, data.actual)
   },
   error: ajaxFailureCallback
  });
 
 })

```


### another chart

```js
//將資料整理並且畫圖
 var bindData = function (xBar ,estimate, actual){
  var data = {
           labels: xBar,
           datasets: [
             {
               label: "預算金額(元)",
               data: estimate,
               backgroundColor: "rgba(256,0,0,1)",
               lineTension: 0
             }, {
               label: "實際金額(元)",
               data: actual,             
               backgroundColor: "rgba(0,0,256,1)",
               lineTension: 0
             }
           ]
         };
        
  var  options = {
           animation: {
               duration: 1000, // 生成圖形的時間
           }
   }
  
  myChart = createChart(myChart, ctx, 'bar', data, options);
  
}

```
