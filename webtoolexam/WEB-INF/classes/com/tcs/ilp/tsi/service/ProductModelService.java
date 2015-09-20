package com.tcs.ilp.tsi.service;


//import com.tcs.ilp.tsi.dao.ProductModelDAO;
import java.util.ArrayList;

import com.tcs.ilp.tsi.vo.ProductModelVO;


public class ProductModelService {
	
	public static ArrayList<ProductModelVO> threshold(ArrayList<ProductModelVO> alPVO) {
		// TODO Auto-generated method stub
		int thresholdlimit=0;
		for(ProductModelVO pVO: alPVO)
		{
			if(pVO.getQuantity()<pVO.getProductModelThreshold())
			{
				thresholdlimit=-1;
				pVO.setThresholdlimit(thresholdlimit);
			}
			else if((pVO.getQuantity()==pVO.getProductModelThreshold())||((pVO.getQuantity()<(pVO.getProductModelThreshold()+10))&&(pVO.getQuantity()>=pVO.getProductModelThreshold())))
			{
				
				thresholdlimit=0;
				pVO.setThresholdlimit(thresholdlimit);
			}
			else
			{
				thresholdlimit=1;
				pVO.setThresholdlimit(thresholdlimit);
			}
		}
		return alPVO;
	}
	
}
