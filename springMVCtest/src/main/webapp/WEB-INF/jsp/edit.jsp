<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
        <title>Edit CD</title>
    </head>
    <body>
        <h1>Please fill in CD columns</h1>
        <form:form method="post" action="/springMVCtest/edit">
            <input name="title" type="hidden" value = "${cd.title}"/>
            <table>
		        <tr>
		            <td>Title</td>
		            <td><label>${cd.title}</label></td>
		        </tr>
		        <tr>
		            <td>Artist</td>
		            <td><input name="artist" type="text" value = "${cd.artist}"/></td>
		        </tr>
		        <tr>
		            <td>Country</td>
		            <td><input name="country" type="text" value = "${cd.country}"/></td>
		        </tr>
		        <tr>
		            <td>Company</td>
		            <td><input name="company" type="text" value = "${cd.company}"/></td>
		        </tr>
		        <tr>
		            <td>Price</td>
		            <td><input name="price" type="text" value = "${cd.price}"/></td>
		        </tr>
		        <tr>
		            <td>Year</td>
		            <td><input name="year" type="text" value = "${cd.year}"/></td>
		        </tr>
		        <tr>
		            <td colspan="2">
		                <input type="submit" value="Update CD" />
		            </td>
		        </tr>
    		</table>
        </form:form>
    </body>
</html>