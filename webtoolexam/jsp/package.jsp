<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>


<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link href="http://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet" type="text/css">
<script src="../js/togglemodel.js"></script>

<title>Complementary Packages</title>
</head>


<body>
	<div>
		<header><h1>TSI</h1></header>
		<section class="choose-area">
		<a href="index.jsp">
		<span class="customSelect choose-property">
		<span class="customSelectInner">
		Home
		<a href="#" onclick="toggle_visibility_model( 'box3-sub1', 'box3-sub2', 'box3-sub3', 'box3-sub4', 'box3-sub5' );">
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
		
		
		<section id="box3-sub1" class="choose-area">
		<a href="addPackage.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Add Package
		</span>
		</span>
		</a>
		</section>
		
		<section id="box3-sub2" class="choose-area">
		<a href="deletePackage.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Delete Package
		</span>
		</span>
		</a>
		</section>
		
		<section id="box3-sub3" class="choose-area">
		<a href="viewPackage.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		View Package
		</span>
		</span>
		</a>
		</section>
		
		<section id="box3-sub4" class="choose-area">
		<a href="updatePackage.jsp">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner">
		Update Package 
		</span>
		</span>
		</a>
		</section>
		
		<section id="box3-sub5" class="choose-area">
		<span class="customSelect-black choose-property-sub-black">
		<span class="customSelectInner cf">
		Select Package 
		</span>
		</span>
		</section>
		
	</div>
</body>

</html>
