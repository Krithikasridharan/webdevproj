function validate()
{
	var yesName = /^[a-zA-Z0-9 _.]+$/i;
	var yesDescFeat = /^[a-zA-Z0-9 &%+=@_.]+$/i;
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	if((document.updateProduct.productname.value=="") || (document.updateProduct.productname.value==null)) 
	{
		returnValue = false;
		alert("Product model name cannot be empty");
		document.updateProduct.productname.focus();
		return false;
		
	}
	if (/\s/.test(document.updateProduct.productname.value)) 
	{  
		if (!/\w/.test(document.updateProduct.productname.value))
		{
		alert("Blank space");
		return false;	
		}
	
	}
	
	if (!yesName.test(document.updateProduct.productname.value)) 
	{
			returnValue = false;
			alert ("Invalid text format in product model name");
			document.updateProduct.productname.value="";
			document.updateProduct.productname.focus();
			return false;
	}
	
	if((document.updateProduct.description.value=="") || (document.updateProduct.description.value==null))
	{
		returnValue = false;
		alert("Product model Description cannot be empty");
		document.updateProduct.description.focus();
		return returnValue;
	}
	if (/\s/.test(document.updateProduct.description.value)) 
	{  
		if (!/\w/.test(document.updateProduct.description.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if (!yesDescFeat.test(document.updateProduct.description.value)) 
	{
		returnValue = false;
		alert ("Invalid text format in product model description");
		document.updateProduct.description.value="";
		document.updateProduct.description.focus();
		return returnValue;
	}
	
	if((document.updateProduct.features.value=="") || (document.updateProduct.features.value==null))
	{
		returnValue = false;
		alert("Product model features cannot be empty");
		document.updateProduct.features.focus();
		return returnValue;
	}
	if (/\s/.test(document.updateProduct.features.value))
	{  
		if (!/\w/.test(document.updateProduct.features.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if (!yesDescFeat.test(document.updateProduct.features.value)) 
	{
		returnValue = false;
		alert ("Invalid text format in product model features");
		document.updateProduct.features.value="";
		document.updateProduct.features.focus();
		return returnValue;
	}
	if((document.updateProduct.price.value=="") || (document.updateProduct.price.value==null))
	{
		returnValue = false;
		alert("Model price cannot be empty");
		document.updateProduct.price.focus();
		return returnValue;
	}
	if (/\s/.test(document.updateProduct.price.value))
	{  

		if (!/\w/.test(document.updateProduct.price.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if(!numbers.test(document.updateProduct.price.value))
	{
		returnValue = false;
		alert("Price should be of numeric type");
		document.updateProduct.price.value="";
		document.updateProduct.price.focus();
		return returnValue;
	}
	if((document.updateProduct.threshold.value=="") || (document.updateProduct.threshold.value==null))
	{
		returnValue = false;
		alert("Threshold value cannot be empty");
		document.updateProduct.threshold.focus();
		return returnValue;
	}
	if (/\s/.test(document.updateProduct.threshold.value))
	{  
		if (!/\w/.test(document.updateProduct.threshold.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if(isNaN(document.updateProduct.threshold.value))
	{
		returnValue = false;
		alert("Threshold value should be of numeric type");
		document.updateProduct.threshold.value="";
		document.updateProduct.threshold.focus();
		return returnValue;
	}
	else
	{
		return returnValue;
	}
}