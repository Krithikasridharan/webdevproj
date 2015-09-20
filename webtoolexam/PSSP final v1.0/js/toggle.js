 function toggle_visibility(id1, id2, id3) {
       var box1 = document.getElementById(id1);
	   var box2 = document.getElementById(id2);
	   var box3 = document.getElementById(id3);
       
	   
	   if(box1.style.display == 'block')
	    {
		  box1.style.display = 'none';
		}
       else
		{
          box1.style.display = 'block';
		}
		
		if(box2.style.display == 'block')
	    {
          box2.style.display = 'none';
		}
       else
		{
          box2.style.display = 'block';
		}
		
		if(box3.style.display == 'block')
	    {
          box3.style.display = 'none';
		}
       else
		{
          box3.style.display = 'block';
		}
		
    }
	
