	
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


	//將ajax的錯誤分類並提示
	function ajaxFailureCallback(jqXHR){
		switch (jqXHR.status){
		case 404: alert("目標資源不存在");break;
		case 401: alert("請重新登入");
				window.location.href='/aptg-scheduler';break;
		case 500: //alert("發生系統錯誤: "+jqXHR.responseText);break;
			$("<div title='Information'>"+jqXHR.responseText+"</div>").dialog({
				modal: true,
				buttons: {
					"確定": function(){
						var confirmDlg = $(this);
						confirmDlg.dialog("close");
					}
				}
			});
			break;
			case 0: alert('請求被取消');break;
			default: alert(jqXHR.responseText);break;
		}
	}