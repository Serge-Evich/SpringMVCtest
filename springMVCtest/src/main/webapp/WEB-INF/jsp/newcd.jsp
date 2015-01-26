<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Add new CD to Catalog</title>
    </head>
    <body>
        <h1>Please upload a file</h1>
        <form:form method="post" action="/springMVCtest/newcd">
            <table>
		        <tr>
		            <td>Title</td>
		            <td><input name="title" type="text"/></td>
		        </tr>
		        <tr>
		            <td>Artist</td>
		            <td><input name="artist" type="text"/></td>
		        </tr>
		        <tr>
		            <td>Country</td>
		            <td><input name="country" type="text"/></td>
		        </tr>
		        <tr>
		            <td>Company</td>
		            <td><input name="company" type="text"/></td>
		        </tr>
		        <tr>
		            <td>Price</td>
		            <td><input name="price" type="text"/></td>
		        </tr>
		        <tr>
		            <td>Year</td>
		            <td><input name="year" type="text"/></td>
		        </tr>
		        <tr>
		            <td colspan="2">
		                <input type="submit" value="Add CD" />
		            </td>
		        </tr>
    		</table>
        </form:form>
    </body>
</html>