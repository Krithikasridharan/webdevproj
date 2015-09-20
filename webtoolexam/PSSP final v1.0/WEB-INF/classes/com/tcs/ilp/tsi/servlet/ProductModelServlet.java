package com.tcs.ilp.tsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.tsi.dao.ProductModelDAO;
import com.tcs.ilp.tsi.service.ProductModelService;
import com.tcs.ilp.tsi.vo.ProductModelVO;
import com.tcs.ilp.tsi.vo.RetailerVO;

/**
 * Servlet implementation class ProductModelServlet
 */
public class ProductModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int updateX = 0;
	
	

    /**
     * Default constructor. 
     */
    public ProductModelServlet() {
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
		
		
		String hidden=request.getParameter("choicer");
		int count=0;
		ProductModelDAO prodDao = new ProductModelDAO();
		ProductModelVO prodMod = new ProductModelVO();
		ProductModelVO pVO;
		ArrayList<ProductModelVO> alPVO=new ArrayList<ProductModelVO>();
		ArrayList<RetailerVO> alRVO=new ArrayList<RetailerVO>();
		int id=0;
		
		
	//add product model form	
	if(hidden.equals("adder"))
	{
		String productModelName = request.getParameter("prodModelName");
		String productModelDescription = request.getParameter("prodModelDescrip");
		String productModelFeatures = request.getParameter("prodModelFeat");
		float productModelPrice = Float.parseFloat(request.getParameter("prodModelPrice"));
		int productModelThreshold = Integer.parseInt(request.getParameter("prodModelThresh"));
		int retailerID=0;
		if(request.getParameter("retailerID").equalsIgnoreCase(null))
		{
			retailerID=Integer.parseInt(request.getParameter("retailerID"));
		}
		//System.out.println(retailerID);
				
		//prodMod.setProductModelId(productModelId);
		prodMod.setProductModelName(productModelName);
		prodMod.setProductModelDescription(productModelDescription);
		prodMod.setProductModelFeatures(productModelFeatures);
		prodMod.setProductModelPrice(productModelPrice);
		prodMod.setProductModelThreshold(productModelThreshold);
		prodMod.setRetailerID(retailerID);
		
		count=prodDao.add(prodMod);
		//System.out.println(count);
			if(count!=0)
			{
				request.setAttribute("result", "Product Model Added");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/success.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
				rd.forward(request, response);
			}
		
	}//end add model form
		
	//This IF block is to retrieve the available retailers id
	else if(hidden.equalsIgnoreCase("addPM"))
	{
		alRVO=prodDao.viewRetailerId();
		request.setAttribute("ArrayList", alRVO);
		RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/addproductmodel.jsp");
		rd1.forward(request, response);
	}
	
	//This block is to retrieve the available product models
		else if(hidden.equals("viewcaller"))
		{
			List<ProductModelVO> lister = new ArrayList<ProductModelVO>();	
			lister = prodDao.viewAll();
			
			request.setAttribute("order", "");
			request.setAttribute("arrayList", lister);
			RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/viewall.jsp");
			rd1.forward(request, response);
		}
	//This block is to retrieve the available product model id
		else if(hidden.equals("deleteSelectID"))
		{ 
			List<ProductModelVO> lister = new ArrayList<ProductModelVO>();
			lister=prodDao.viewProductModelID();
			request.setAttribute("list", lister);
			RequestDispatcher view=request.getRequestDispatcher("jsp/deleteproductmodel.jsp");
			view.forward(request, response);
		}
	//This block is to delete the selected product model
		else if(hidden.equals("deleterbykey"))
		{
			id=Integer.parseInt(request.getParameter("productModelID"));
			count=prodDao.delete(id);
			if(count!=0)
			{
				request.setAttribute("result", "Deleted");
				RequestDispatcher view= request.getRequestDispatcher("jsp/success.jsp");
				view.forward(request, response);
			}
			else
			{
				RequestDispatcher view= request.getRequestDispatcher("jsp/error.jsp");
				view.forward(request, response);
			}
		}
	//This block is to retrieve the available product model id
		else if(hidden.equals("updateSelectID"))
		{
			List<ProductModelVO> lister = new ArrayList<ProductModelVO>();
			lister=prodDao.viewProductModelID();
			request.setAttribute("list", lister);
			RequestDispatcher view=request.getRequestDispatcher("jsp/selectIdUpdateProductModel.jsp");
			view.forward(request, response);
		}
	//This block is to retrieve the details of selected product model id	
		else if(hidden.equalsIgnoreCase("updateID"))
		{  
			ProductModelVO prodMod1 = new ProductModelVO();
			id=Integer.parseInt(request.getParameter("productModelID"));
			prodMod.setProductModelId(id);
            prodMod1= prodDao.findProduct(prodMod);
			request.setAttribute("object", prodMod1);
			alRVO=prodDao.viewRetailerId();
			request.setAttribute("list",alRVO);
			request.setAttribute("ID", id);
			RequestDispatcher view1=request.getRequestDispatcher("jsp/updateProductdetails.jsp");
			view1.forward(request, response);
		}
	//This block is to update the details of select product model id
		else if(hidden.equals("update"))
		{
			    id=Integer.parseInt(request.getParameter("id"));
				String prodName=request.getParameter("productname");
				String prodDescription=request.getParameter("description");
				String prodFeatures=request.getParameter("features");
				float prodPrice=Float.parseFloat(request.getParameter("price"));
				int prodThreshold=Integer.parseInt(request.getParameter("threshold"));
				
				int retailerid=0;
				if(request.getParameter("retailerID")!="")
				{
					retailerid=Integer.parseInt(request.getParameter("retailerID"));
				}
				prodMod.setRetailerID(retailerid);
				prodMod.setProductModelId(id);
				prodMod.setProductModelName(prodName);
				prodMod.setProductModelDescription(prodDescription);
				prodMod.setProductModelFeatures(prodFeatures);
				prodMod.setProductModelPrice(prodPrice);
				prodMod.setProductModelThreshold(prodThreshold);
				count=prodDao.update(prodMod);
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
		else if(hidden.equalsIgnoreCase("sort"))
		{
			
			String sorttype=request.getParameter("sort");
			if(sorttype.equalsIgnoreCase("sortbyIDAsc"))
			{
				try
				{
					alPVO=prodDao.sortByIdAsc();
					
					//request.setAttribute("order", "ascending");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyproductidasc.jsp");
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
				
					alPVO=prodDao.sortByIdDes();
					//request.setAttribute("order", "descending");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyproductiddes.jsp");
					view.forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(sorttype.equalsIgnoreCase("sortbyQuantityAsc"))
			{
				try
				{
				
					alPVO=prodDao.sortByAmountAsc();
					
					//request.setAttribute("order", "Qascending");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyquantityasc.jsp");
					view.forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(sorttype.equalsIgnoreCase("sortbyQuantityDes"))
			{
				try
				{
					alPVO=prodDao.sortByAmountDes();
					//request.setAttribute("order", "Qdescending");
					request.setAttribute("arrayList",alPVO);
					RequestDispatcher view=request.getRequestDispatcher("jsp/sortbyquantitydes.jsp");
					view.forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		else if(hidden.equalsIgnoreCase("threshold"))
		{
			try
			{
		//System.out.println(hidden);
				//int thresholdLimit=0;
			alPVO=prodDao.viewThreshold();
			alPVO=ProductModelService.threshold(alPVO);
			//request.setAttribute("limit",thresholdLimit );
			request.setAttribute("arrayList",alPVO);
			RequestDispatcher view=request.getRequestDispatcher("jsp/viewThresholdLegends.jsp");
			view.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
		

