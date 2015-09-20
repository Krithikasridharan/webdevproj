function validate()
{
	
	
	
	var letters = /^[a-zA-Z0-9 +=@_.]+$/i;
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	
	if(document.updatePackageForm.offers.value=="" || document.updatePackageForm.offers.value==null )
		{
			returnValue=false;
			alert("Offers field cannot be empty");
			document.updatePackageForm.offers.value = "";
            document.updatePackageForm.offers.focus();
			return returnValue;
		}
	 if(document.updatePackageForm.amount.value=="" || document.updatePackageForm.amount.value== null)
		{
			returnValue=false;
			alert("Amount field cannot be empty");
			document.updatePackageForm.amount.value = "";
            document.updatePackageForm.amount.focus();
			return returnValue;
		}
	 if(!letters.test(document.updatePackageForm.offers.value))
		{
			returnValue=false;
			alert("Invalid format of text in offers field");
			document.updatePackageForm.offers.value = "";
            document.updatePackageForm.offers.focus();
			return returnValue;
		}
	 if(!document.updatePackageForm.amount.value.match(numbers))
		{
			returnValue=false;
			alert("Amount field should be a numeric type");
			document.updatePackageForm.amount.value = "";
            document.updatePackageForm.amount.focus();
			return returnValue;
		}
	else
	{
		alert("Update Success");
	return returnValue;
	}
}
