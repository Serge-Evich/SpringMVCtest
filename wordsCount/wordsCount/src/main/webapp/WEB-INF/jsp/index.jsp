<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  
   <script type="text/javascript">
   $(document).ready(function() {
	   
	   $('#textForm').submit(function(event) {
		   event.preventDefault();
		   var text = $('#text').val();
		   var json = { "text" : text};
	       $('#response').html(text); 
	     $.ajax({
	         url: $('#textForm').attr("action"),
	         type: 'POST',
	         //dataType: 'json',
	        // contentType: 'application/json',
	         data: JSON.stringify(json),
	         
	          
	         beforeSend: function(xhr) {
	           xhr.setRequestHeader("Accept", "application/json");
	           xhr.setRequestHeader("Content-Type", "application/json");
	         },
	         success: function(respJSON) {
	             var respContent = "";
	             
	             respContent += "<span class='success'>some response: [";
	             respContent += respJSON + "]</span>";
	               
	              
	             $('#response').html(respContent);         
	         }
	     });
	       
	    
	   });
	     
	 });
</script>
   <head>
        <title>Edit CD</title>
    </head>
    <body>
        <h1>Please fill in CD columns</h1>
        <form:form id = "textForm" method="post" action="/getWordsCount">
            <input id="text" type="text"/>
            <div id = "response">1</div>
		    <input type="submit" value="Update CD" />
		</form:form>
    </body>
</html>