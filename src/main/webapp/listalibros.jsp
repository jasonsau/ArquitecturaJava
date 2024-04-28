<%@ page import="java.sql.*" %>
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

		List<String> categorias =(List<String>) request.getAttribute("listaCategorias");
		out.println("<select name = 'categoria'>");
		for(String categoria: categorias) {
			out.println("<option>"+categoria+"</option>");
		}
		out.println("</select>");

		List<LibroAR> listaLibros = (List<LibroAR>) request.getAttribute("listaLibros");
		out.println("<h2>Lista de Libros</h2>");
		out.println("<table border ='1'>");
		out.println("<tr><th>ISBN</th><th>Titulo</th><th>Categoria</th></tr>");
		
		for(LibroAR libro: listaLibros) {
			out.println(
					"<tr><td>" + 
					libro.getIsbn() + "</td><td>" +
					libro.getTitulo() + "</td><td>" + 
					libro.getCategoria() + "</td><td>" +
					"<a href=?accion=borrarlibro&isbn="+libro.getIsbn()+">borrar</a></td>" +
					"</tr>"
			);
		}
		out.println("</table>");

	%>

	<a href = "?accion=formularionuevolibro">Nuevo</a>
</body>
</html>