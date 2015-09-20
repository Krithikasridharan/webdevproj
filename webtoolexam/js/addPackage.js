function validate()
{
	
	
	
	var letters = /^[a-zA-Z0-9 +=@_.]+$/i;
	var numbers = /^[0-9.]+$/;
	var returnValue = true;
	
	if(document.addPackageForm.offers.value=="" || document.addPackageForm.offers.value==null )
		{
			returnValue=false;
			alert("Offers field cannot be empty");
			document.addPackageForm.offers.value = "";
            document.addPackageForm.offers.focus();
			return returnValue;
		}
	 if(document.addPackageForm.amount.value=="" || document.addPackageForm.amount.value== null)
		{
			returnValue=false;
			alert("Amount field cannot be empty");
			document.addPackageForm.amount.value = "";
            document.addPackageForm.amount.focus();
			return returnValue;
		}
	 if(!letters.test(document.addPackageForm.offers.value))
		{
			returnValue=false;
			alert("Invalid format of text in offers field");
			document.addPackageForm.offers.value = "";
            document.addPackageForm.offers.focus();
			return returnValue;
		}
	 if(!document.addPackageForm.amount.value.match(numbers))
		{
			returnValue=false;
			alert("Amount field should be a numeric type");
			document.addPackageForm.amount.value = "";
            document.addPackageForm.amount.focus();
			return returnValue;
		}
	else
	{
		alert("Add Success");
	return returnValue;
	}
}
