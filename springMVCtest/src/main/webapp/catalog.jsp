<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Car List</h1>

	<c:forEach items="${cdList}" var="cd">
		CD Title = ${cd.title}; CD Artist = ${cd.artist}; CD Country = ${cd.country};
		CD Company = ${cd.company}; CD Price = ${cd.price}; CD year = ${cd.year};
		<br />
	</c:forEach>

 </body>
</html>