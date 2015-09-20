function validate()
{
	
	var yesName = /^[a-zA-Z0-9 _.]+$/i;
	var yesDescFeat = /^[a-zA-Z0-9 &%+=@_.]+$/i;
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	if((document.addprodmod.prodModelName.value=="") || (document.addprodmod.prodModelName.value==null)) 
	{
		returnValue = false;
		alert("Product model name cannot be empty");
		document.addprodmod.prodModelName.focus();
		return false;
		
	}
	if (/\s/.test(document.addprodmod.prodModelName.value)) 
	{  
		if (!/\w/.test(document.addprodmod.prodModelName.value))
		{
		alert("Blank space");
		return false;	
		}
	
	}
	
	if (!yesName.test(document.addprodmod.prodModelName.value)) 
	{
			returnValue = false;
			alert ("Invalid text format in product model name");
			document.addprodmod.prodModelName.value="";
			document.addprodmod.prodModelName.focus();
			return false;
	}
	
	if((document.addprodmod.prodModelDescrip.value=="") || (document.addprodmod.prodModelDescrip.value==null))
	{
		returnValue = false;
		alert("Product model Description cannot be empty");
		document.addprodmod.prodModelDescrip.focus();
		return returnValue;
	}
	if (/\s/.test(document.addprodmod.prodModelDescrip.value)) 
	{  
		if (!/\w/.test(document.addprodmod.prodModelDescrip.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if (!yesDescFeat.test(document.addprodmod.prodModelDescrip.value)) 
	{
		returnValue = false;
		alert ("Invalid text format in product model description");
		document.addprodmod.prodModelDescrip.value="";
		document.addprodmod.prodModelDescrip.focus();
		return returnValue;
	}
	
	if((document.addprodmod.prodModelFeat.value=="") || (document.addprodmod.prodModelFeat.value==null))
	{
		returnValue = false;
		alert("Product model features cannot be empty");
		document.addprodmod.prodModelFeat.focus();
		return returnValue;
	}
	if (/\s/.test(document.addprodmod.prodModelFeat.value))
	{  
		if (!/\w/.test(document.addprodmod.prodModelFeat.value))
		{
			alert("Blank space");
		}
	}
	if (!yesDescFeat.test(document.addprodmod.prodModelFeat.value)) 
	{
		returnValue = false;
		alert ("Invalid text format in product model features");
		document.addprodmod.prodModelFeat.value="";
		document.addprodmod.prodModelFeat.focus();
		return returnValue;
	}
	if((document.addprodmod.prodModelPrice.value=="") || (document.addprodmod.prodModelPrice.value==null))
	{
		returnValue = false;
		alert("Model price cannot be empty");
		document.addprodmod.prodModelPrice.focus();
		return returnValue;
	}
	if (/\s/.test(document.addprodmod.prodModelPrice.value))
	{  

		if (!/\w/.test(document.addprodmod.prodModelPrice.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if(!numbers.test(document.addprodmod.prodModelPrice.value))
	{
		returnValue = false;
		alert("Price should be of numeric type");
		document.addprodmod.prodModelPrice.value="";
		document.addprodmod.prodModelPrice.focus();
		return returnValue;
	}
	if((document.addprodmod.prodModelThresh.value=="") || (document.addprodmod.prodModelThresh.value==null))
	{
		returnValue = false;
		alert("Threshold value cannot be empty");
		document.addprodmod.prodModelThresh.focus();
		return returnValue;
	}
	if (/\s/.test(document.addprodmod.prodModelThresh.value))
	{  
		if (!/\w/.test(document.addprodmod.prodModelThresh.value))
		{
			alert("Blank space");
			return false;	
		}
	}
	if(isNaN(document.addprodmod.prodModelThresh.value))
	{
		returnValue = false;
		alert("Threshold value should be of numeric type");
		document.addprodmod.prodModelThresh.value="";
		document.addprodmod.prodModelThresh.focus();
		return returnValue;
	}
	else
	{
		return returnValue;
	}
}