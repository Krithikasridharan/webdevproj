<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<script src="../js/togglemodel.js"></script>

<title>Stock</title>
</head>


<body>
	<div>
		<header><h1>TSI</h1></header>
		<section class="choose-area">
		<a href="index.jsp">
		<span class="customSelect choose-property">
		<span class="customSelectInner">
		Home 
		<a href="#" onclick="toggle_visibility_model( 'box2-sub1', 'box2-sub2', 'box2-sub3', 'box2-sub4', 'box2-sub5' );">
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
		
		
		<section id="box2-sub1" class="choose-area">
		<a href="addStock.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Add Stock
		</span>
		</span>
		</a>
		</section>
		
		<section id="box2-sub2" class="choose-area">
		<a href="deletestock1.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Delete Stock
		</span>
		</span>
		</a>
		</section>
		
		<section id="box2-sub3" class="choose-area">
		<a href="viewStock1.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		View Stock
		</span>
		</span>
		</a>
		</section>
		
		<section id="box2-sub4" class="choose-area">
		<a href="updatestock1.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Update Stock 
		</span>
		</span>
		</a>
		</section>
		
		<section id="box2-sub5" class="choose-area">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner cf">
		Select Stock 
		</span>
		</span>
		</section>
		
	</div>
</body>

</html>