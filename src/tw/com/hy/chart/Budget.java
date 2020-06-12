package tw.com.hy.chart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tw.com.hy.chart.data.BudgetData;
import tw.com.hy.chart.service.SetDataService;

/**
 * Servlet implementation class ChartJs
 */
@WebServlet("/budget.do")
public class Budget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Budget() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = (String)request.getParameter("type");
		
		SetDataService service = new SetDataService();
		BudgetData result = service.setData(type);
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().write(gson.toJson(result));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
