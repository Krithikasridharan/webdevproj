package com.tcs.ilp.tsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.tsi.dao.PackageDAO;
import com.tcs.ilp.tsi.vo.PackageVO;
import com.tcs.ilp.tsi.vo.RewardVO;

/**
 * Servlet implementation class PackageServlet
 */
public class PackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PackageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hidden=request.getParameter("Package");
		PrintWriter out=response.getWriter();
		out.print(request.getParameter("Package"));
		PackageVO vo=new PackageVO();
		PackageDAO dao=new PackageDAO();
		
		int id=0,count=0;
		ArrayList<RewardVO> alRVO=new ArrayList<RewardVO>();
		ArrayList<PackageVO> alPVO=new ArrayList<PackageVO>();
		if(hidden.equalsIgnoreCase("add"))
			{ 
				float amount=Float.parseFloat(request.getParameter("amount"));
				String offers=request.getParameter("offers");
				vo.setOffers(offers);
				vo.setAmount(amount);
				count=dao.addPackage(vo);
				if(count!=0)
				{
					request.setAttribute("result","Added");
					RequestDispatcher view=request.getRequestDispatcher("jsp/success.jsp");
					view.forward(request, response);	
				}
				else
				{
					RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
					view.forward(request, response);
				}
				
			}
		else if(hidden.equalsIgnoreCase("view"))
			{
				try
					{
					
						alPVO=dao.viewPackage();
						//request.setAttribute("order","");
						request.setAttribute("arrayList",alPVO);
						RequestDispatcher view=request.getRequestDispatcher("jsp/successViewPackage.jsp");
						view.forward(request, response);
					}
				catch(Exception e){
				e.printStackTrace();
			}
				
			}
		else if(hidden.equalsIgnoreCase("updateselectID"))
			{
				alPVO=dao.viewPackageId();
				request.setAttribute("arrayList",alPVO);
				RequestDispatcher view=request.getRequestDispatcher("jsp/selectIdUpdatePackage.jsp");
				view.forward(request, response);
				
			}
		else if(hidden.equalsIgnoreCase("updateID"))
			{
				
				id=Integer.parseInt(request.getParameter("packageID"));
				request.setAttribute("ID", id);
			    vo.setPackage_id(id);
				alPVO=dao.findPackage(vo);
				request.setAttribute("arrayList",alPVO);
				RequestDispatcher view=request.getRequestDispatcher("jsp/updatePackageOffers.jsp");
				view.forward(request, response);
				
				
			}
		else if(hidden.equalsIgnoreCase("update"))
			{
			    id=Integer.parseInt(request.getParameter("id"));
				String offers=request.getParameter("offers");
				float amount=Float.parseFloat(request.getParameter("amount"));
				vo.setPackage_id(id);
				vo.setOffers(offers);
				vo.setAmount(amount);
				
				count=dao.updatePackage(vo);
				if(count!=0)
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
		else if(hidden.equalsIgnoreCase("deleteSelectID"))
		{
			alPVO=dao.viewPackageId();
			request.setAttribute("arrayList",alPVO);
			RequestDispatcher view=request.getRequestDispatcher("jsp/selectIdDeletePackage.jsp");
			view.forward(request, response);
		}
		else if(hidden.equalsIgnoreCase("deleteID"))
		{
			id=Integer.parseInt(request.getParameter("packageID"));
		    count=dao.deletePackage(id);
			if(count!=0)
			{
				request.setAttribute("result","Deleted");
				RequestDispatcher view=request.getRequestDispatcher("jsp/success.jsp");
				view.forward(request, response);
			}
			else
			{
				RequestDispatcher view=request.getRequestDispatcher("jsp/error.jsp");
				view.forward(request, response);
			}
		}
		else if(hidden.equalsIgnoreCase("viewRewards"))
		{
			//System.out.println("View Rewards");
			alRVO=dao.viewRewards();
			request.setAttribute("arrayList",alRVO);
			RequestDispatcher view=request.getRequestDispatcher("jsp/successViewRewards.jsp");
			view.forward(request, response);
		}
		else if(hidden.equalsIgnoreCase("sort"))
		{
			
			String sorttype=request.getParameter("sort");
			if(sorttype.equalsIgnoreCase("sortbyIDAsc"))
			{
				try
				{
				
					alPVO=dao.sortByIdAsc();
					//request.setAttribute("order","asc");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyidasc.jsp");
					view.forward(request, response);
				}
			catch(Exception e){
			e.printStackTrace();
			}
			}
			else if(sorttype.equalsIgnoreCase("sortbyIDDes"))
			{
				try
				{
				
					alPVO=dao.sortByIdDes();
				//	request.setAttribute("order","desc");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyiddes.jsp");
					view.forward(request, response);
				}
			catch(Exception e){
			e.printStackTrace();
			}
			}
			else if(sorttype.equalsIgnoreCase("sortbyAmountAsc"))
			{
				try
				{
				
					alPVO=dao.sortByAmountAsc();
				//	request.setAttribute("order","aasc");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyamountasc.jsp");
					view.forward(request, response);
				}
			catch(Exception e){
			e.printStackTrace();
			}
			}
			else if(sorttype.equalsIgnoreCase("sortbyAmountDes"))
			{
				try
				{
				
					alPVO=dao.sortByAmountDes();
					//request.setAttribute("order","adesc");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyamountdes.jsp");
					view.forward(request, response);
				}
			catch(Exception e){
			e.printStackTrace();
			}
			}
		}
 	}

}
