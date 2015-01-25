<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalog</title>
    </head>
    <body>
        <div align="center">
            <h1>CD Catalog</h1>
            <h2><a href="newcd">New CD</a></h2>
             
            <table border="1">
                <th>Title</th>
                <th>Artist</th>
                <th>Country</th>
                <th>Company</th>
                <th>Price</th>
                <th>Year</th>
                 
                <c:forEach var="cd" items="${cdList}">
                <tr>
                    <td>${cd.title}</td>
                    <td>${cd.artist}</td>
                    <td>${cd.country}</td>
                    <td>${cd.company}</td>
                    <td>${cd.price}</td>
                    <td>${cd.year}</td>
                    <td>
                        <a href="/edit?id=${cd.title}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=${cd.title}">Delete</a>
                    </td>
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>