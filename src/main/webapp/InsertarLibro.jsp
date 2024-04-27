<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "web1.LibroAR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guardar Libro</title>
</head>
<body>

	<%
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		LibroAR libro = new LibroAR(isbn, titulo, categoria);
		libro.insertar();
		response.sendRedirect("listalibros.jsp");
	%>
	
</body>
</html>