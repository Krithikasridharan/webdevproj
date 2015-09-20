function validate()
{
	//alert("check");
	
	var yesName = /^[a-zA-Z0-9 _.]+$/i; 
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	if((document.updateform.productmodelid.value=="") || (document.updateform.productmodelid.value==null)) 
	{
		returnValue = false;
		alert("Product model id cannot be empty");
		document.updateform.productmodelid.focus();
		return returnValue;
		
	}
	if (/\s/.test(document.updateform.productmodelid.value)) 
	{  
		if (!/\w/.test(document.updateform.productmodelid.value))
		{
		returnValue = false;
		alert("Product model id cannot be empty");
		document.updateform.productmodelid.focus();
		return returnValue;	
		}
	
	}
	if(!numbers.test(document.updateform.productmodelid.value))
	{
		returnValue = false;
		alert("Product model id should be of numeric type ");
		document.updateform.productmodelid.value="";
		document.updateform.productmodelid.focus();
		return returnValue;
	}
	if((document.updateform.productname.value=="") || (document.updateform.productname.value==null)) 
	{
		returnValue = false;
		alert("Product name cannot be empty");
		document.updateform.productname.focus();
		return returnValue;
		
	}
	if (/\s/.test(document.updateform.productname.value)) 
	{  
		if (!/\w/.test(document.updateform.productname.value))
		{
			returnValue = false;
			alert("Product name cannot be empty");
			document.updateform.productname.focus();
			return returnValue;
			
		}
	
	}
	
	if (!yesName.test(document.updateform.productname.value)) 
	{
			returnValue = false;
			alert ("Invalid text format in product name");
			document.updateform.productname.value="";
			document.updateform.productname.focus();
			return returnValue;
	}
	else
	{
		return returnValue;
	}
		
}