
package com.tcs.ilp.tsi.servlet;
import com.tcs.ilp.tsi.dao.StockDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tcs.ilp.tsi.vo.StockVO;
//import java.sql.ResultSet;
/**
 * Servlet implementation class ss
 */
public class StockDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockVO svo;
		StockVO svo1;
		StockDAO sdao;
		int i=0;
		if(request.getParameter("Stock").equalsIgnoreCase("add"))//to add the details of the stock
		{
			
			svo=new StockVO();
			sdao=new StockDAO();
		int id=Integer.parseInt(request.getParameter("product"));//get the product modelid from the form
		svo.setProduct_ModelID(id);
		svo.setProductName(request.getParameter("name"));
		svo.setProductStatus("available");
		System.out.println(svo.getProductStatus());
		i=sdao.add(svo);//calling the add method in stockdao file
		if(i!=0)
		{
			sdao.incrementquantity(svo);//if added the quantity is incremented by 1
			request.setAttribute("result","Added");
			RequestDispatcher view=request.getRequestDispatcher("jsp/success.jsp");
			view.forward(request,response);	
		}
		else{
			RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
			view.forward(request, response);
		}
		}
		else if(request.getParameter("Stock").equalsIgnoreCase("viewpcode"))
	{
		sdao=new StockDAO();
		List<StockVO> up=new ArrayList<StockVO>();
		up=sdao.viewproductid();		
		
		request.setAttribute("al", up);
		RequestDispatcher view=request.getRequestDispatcher("jsp/updateStock.jsp");
		view.forward(request,response);
	}
	else if(request.getParameter("Stock").equalsIgnoreCase("update"))
	{
		svo=new StockVO();
		svo1=new StockVO();
	    sdao=new StockDAO();
		int id=Integer.parseInt(request.getParameter("pcode"));
		svo.setProductCode(id);
		svo1=sdao.Select(svo);
		int chk=sdao.checkupdate(svo1);
		if(chk==1)
		{
		request.setAttribute("Previous",svo1);
		RequestDispatcher view=request.getRequestDispatcher("jsp/select.jsp");
		view.forward(request,response);
		
	}
		else
		{
			RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
			view.forward(request, response);
		}
	}
		
	else if(request.getParameter("Stock").equalsIgnoreCase("select"))
	{
		svo=new StockVO();
		sdao=new StockDAO();			
		svo.setProductCode(Integer.parseInt(request.getParameter("Next")));
		svo.setProduct_ModelID(Integer.valueOf(request.getParameter("productmodelid")));
		svo.setProductStatus(request.getParameter("productstatus"));
		svo.setProductName(request.getParameter("productname"));
		i=sdao.update(svo);	
		if(i!=0)
		{
			request.setAttribute("result","Updated");
			RequestDispatcher view=request.getRequestDispatcher("jsp/success.jsp");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
			view.forward(request, response);
		}
	}
	else if(request.getParameter("Stock").equalsIgnoreCase("delpcode"))
	{
		sdao=new StockDAO();
		List<StockVO> dp=new ArrayList<StockVO>();
		dp=sdao.viewproductid();		
		request.setAttribute("dl", dp);
		RequestDispatcher view=request.getRequestDispatcher("jsp/deleteStock.jsp");
		view.forward(request,response);
	}
	
	else if(request.getParameter("Stock").equalsIgnoreCase("delete"))
	{
		sdao=new StockDAO();
		
			int num=Integer.parseInt(request.getParameter("pcode"));
	        
		   i= sdao.delete(num);
		
		   if(i!=0)
			{
			   request.setAttribute("result","Deleted");
				RequestDispatcher view=request.getRequestDispatcher("jsp/success.jsp");
				view.forward(request, response);
			}
			else{
				RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
				view.forward(request, response);	
		} }
	else if(request.getParameter("Stock").equalsIgnoreCase("view"))
	{
		try
		{
		sdao=new StockDAO();
		List<StockVO> vp=new ArrayList<StockVO>();
		vp=sdao.viewAll();
		//request.setAttribute("order", "");
		request.setAttribute("view",vp);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/viewStock.jsp");
		rd.forward(request,response);
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	else if(request.getParameter("Stock").equalsIgnoreCase("sort"))
	{
		sdao=new StockDAO();
		List<StockVO> vp=new ArrayList<StockVO>();
		if(request.getParameter("order").equalsIgnoreCase("asc"))
		{
			vp=sdao.SortbyProductCodeascending();
			request.setAttribute("view", vp);
			//request.setAttribute("order", "ascending");
			RequestDispatcher rd=request.getRequestDispatcher("jsp/sortbycodeasc.jsp");
			rd.forward(request,response);
					}
		else
		{
			vp=sdao.SortbyProductCodedescending();
			request.setAttribute("view", vp);
			request.setAttribute("order", "descending");
			RequestDispatcher rd=request.getRequestDispatcher("jsp/sortbycodedes.jsp");
			rd.forward(request,response);
		}
	}
	}
}
