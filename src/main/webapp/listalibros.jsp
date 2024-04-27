<%@ page import="java.sql.*" %>
<%@ page import = "web1.DataBaseHelper" %>
<%@ page import = "web1.LibroAR" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<%
		try {
			List<String> categorias = LibroAR.buscarTodasLasCategorias();
			out.println("<select name = 'categoria'>");
			for(String categoria: categorias) {
				out.println("<option>"+categoria+"</option>");
			}
			out.println("</select>");
		} catch (Exception e) {
			out.println("<p>Error al obtener las categorias</p>");
			e.printStackTrace();
		}
	
	
	
		try {
			List<LibroAR> listaLibros = LibroAR.buscarTodos();
			out.println("<h2>Lista de Libros</h2>");
			out.println("<table border ='1'>");
			out.println("<tr><th>ISBN</th><th>Titulo</th><th>Categoria</th></tr>");
			
			for(LibroAR libro: listaLibros) {
				out.println("<tr><td>" + libro.getIsbn() + "</td><td>" + libro.getTitulo() + "</td><td>" + libro.getCategoria() + "</td></tr>");
			}
			out.println("</table>");

		} catch(Exception e) {
			out.println("<p>Error al procesar la solicitud</p>");
			e.printStackTrace();
		}
	%>

	<a href = "formularionuevolibro.jsp">Nuevo</a>
</body>
</html>