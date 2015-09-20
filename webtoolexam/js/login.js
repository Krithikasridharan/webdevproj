function validate()  
                         {
						
							var yesUname = /^[a-zA-Z0-9@_.]+$/i;
							var yesPwd = /^[a-zA-Z0-9_@.]+$/i;
							//var notUname = /[^=+!@#$%^&*\-\/]/;
							//var notPwd = /[^=+@!#$%^&*\-\/]/;
                            var returnValue=true;
                            
                        
                           
                            
                            if(document.loginform.uname.value==""||document.loginform.uname.value==null)
                            {
                            	returnValue = false;
                            	alert("Username cannot be empty");
                            	document.loginform.uname.value = "";
                                document.loginform.uname.focus();
                                return returnValue;
                            }
                            if(document.loginform.pwd.value==""||document.loginform.pwd.value==null)
                            {
                            	returnValue = false;
                            	alert("Password cannot be empty");
                            	document.loginform.pwd.value = "";
                                document.loginform.pwd.focus();
                                return returnValue;
                            }
                            
                            	
                            if(document.loginform.uname.value.length < 6)
                                  {
                                       returnValue = false;
                                       alert("Your username must be at least\n6 character long.\nPlease try again.");
                                       document.loginform.uname.value = "";
                                       document.loginform.uname.focus();
                                       return returnValue;
                                   }
                    if (document.loginform.pwd.value.length < 6)
                                  {
                                        returnValue = false;
                                        alert("Your password must be at least\n6 characters long.\n  Please try again.");
                                       
                                        document.loginform.pwd.value = "";
                                        document.loginform.pwd.focus();
                                        return returnValue;
                                   }
                    if(!yesUname.test(document.loginform.uname.value))
                    {
                    	returnValue = false;
                    	alert("Invalid characters in username");
                    	document.loginform.uname.value = "";
                        document.loginform.uname.focus();
                        return returnValue;
                    }
                    if(!yesPwd.test(document.loginform.pwd.value))
                    {
                    	returnValue = false;
                    	alert("Invalid characters in password");
                    	document.loginform.pwd.value = "";
                        document.loginform.pwd.focus();
                        return returnValue;
                    }
                 
                   /* if(!notUname.test(document.loginform.uname.value))
                    {
                    	returnValue = false;
                    	alert("Invalid characters in username");
                    	document.loginform.uname.value = "";
                        document.loginform.uname.focus();
                        return returnValue;
                    }
                    if(!notPwd.test(document.loginform.pwd.value))
                    {
                    	returnValue = false;
                    	alert("Invalid characters in password");
                    	document.loginform.pwd.value = "";
                        document.loginform.pwd.focus();
                        return returnValue;
                    }
                    */
                    
                  if(returnValue!=false)
                           {
                                     alert("Success");
                                     
                                     return returnValue;
                            }
                   }