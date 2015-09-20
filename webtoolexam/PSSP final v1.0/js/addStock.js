function validate()
{
	//alert("check");
	
	var yesName = /^[a-zA-Z0-9 _.]+$/i; 
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	if((document.addstockform.product.value=="") || (document.addstockform.product.value==null)) 
	{
		returnValue = false;
		alert("Product model id cannot be empty");
		document.addstockform.product.focus();
		return returnValue;
		
	}
	if (/\s/.test(document.addstockform.product.value)) 
	{  
		if (!/\w/.test(document.addstockform.product.value))
		{
		returnValue = false;
		alert("Product model id cannot be empty");
		document.addstockform.product.focus();
		return returnValue;	
		}
	
	}
	if(!numbers.test(document.addstockform.product.value))
	{
		returnValue = false;
		alert("Product model id should be of numeric type ");
		document.addstockform.product.value="";
		document.addstockform.product.focus();
		return returnValue;
	}
	if((document.addstockform.name.value=="") || (document.addstockform.name.value==null)) 
	{
		returnValue = false;
		alert("Product name cannot be empty");
		document.addstockform.name.focus();
		return returnValue;
		
	}
	if (/\s/.test(document.addstockform.name.value)) 
	{  
		if (!/\w/.test(document.addstockform.name.value))
		{
			returnValue = false;
			alert("Product name cannot be empty");
			document.addstockform.name.focus();
			return returnValue;
			
		}
	
	}
	
	if (!yesName.test(document.addstockform.name.value)) 
	{
			returnValue = false;
			alert ("Invalid text format in product name");
			document.addstockform.name.value="";
			document.addstockform.name.focus();
			return false;
	}
	else
	{
		return returnValue;
	}
		
}