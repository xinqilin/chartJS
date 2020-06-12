<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="PATH" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="commons/include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>預算圖表範例</title>
<script>
$(document).ready(function(){
	
	
	var myChart = null;
    var ctx = document.getElementById('myChart').getContext('2d');
    ctx.canvas.height = 100;

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
		
		myChart = createChart(myChart, ctx, 'line', data, options);
 	
    }
    
	//此段程式為prototype
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



	
})
</script>
</head>
<body>
<form id="select_form" class="form-group" >
	<div class="container">
		<div class='row'>
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading"><h4>查詢條件</h4></div>
					<div class="panel-body">
						<div class='row'>
							<div class='col-md-5'>
								<div class='col-md-3'>
								<label style="line-height:25px;">查詢類別</label>
								</div>
								<div class='col-md-9'> 
									<select id="contractType">
										<option value="INIT">原始合約</option>
										<option value="CR">原始合約+CR</option>
									</select>
								</div>
							</div>
						</div>
						<div class='row'>
							<div class='col-md-4'></div>
							<div class='col-md-2'>
								<input type="button" id="selectBtn" value="查詢" class='form-control btn-primary' />
							</div>
						</div>						
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<br>
<canvas id="myChart"></canvas>
</body>
</html>