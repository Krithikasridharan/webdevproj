<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<script src="../js/togglemodel.js"></script>


<title>Product Model</title>
</head>


<body>
	<div>
		<header><h1>TSI</h1></header>
		<section class="choose-area">
		<a href="index.jsp">
		<span class="customSelect choose-property">
		<span class="customSelectInner">
		Home 
		<a href="#" onclick="toggle_visibility_model( 'box1-sub1', 'box1-sub2', 'box1-sub3', 'box1-sub4', 'box1-sub5' );">
		<span class="block-icon">
			<span></span>
			<span></span> 
			<span></span> 
			<span></span>
			<span></span> 
			<span></span>
		</span>
		</a>
		</span>
		</span>
		</a>
		</section>
		
		
		<section id="box1-sub1" class="choose-area">
		<a href="addPM.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Add Product Model  
		</span>
		</span>
		</a>
		</section>
		
		<section id="box1-sub2" class="choose-area">
		<a href="deleteproduct.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Delete Product Model  
		</span>
		</span>
		</a>
		</section>
		
		<section id="box1-sub3" class="choose-area">
		<a href="viewcaller.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		View Product Model  
		</span>
		</span>
		</a>
		</section>
		
		<section id="box1-sub4" class="choose-area">
		<a href="updateproductmodel.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Update Product Model  
		</span>
		</span>
		</a>
		</section>
		
		<section id="box1-sub5" class="choose-area">
		<a href="viewThreshold.jsp">		
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner cf">
		Quantity Details  
		</span>
		</span>
		</a>
		</section>
		
	</div>
</body>

</html>