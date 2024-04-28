<%@ page import="java.sql.*" %>
<%@ page import = "web1.Libro" %>
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
		String c = (String)request.getAttribute("c");
		out.println("<select name = 'categoria' id='categoria'>");
		for(String categoria: categorias) {
			String selected = "";
			if(c.equals(categoria)) {
				selected = "selected";
			}
			out.println("<option " + selected + ">"+categoria+"</option>");
		}
		out.println("</select>");

		List<Libro> listaLibros = (List<Libro>) request.getAttribute("listaLibros");
		out.println("<h2>Lista de Libros</h2>");
		out.println("<table border ='1'>");
		out.println("<tr><th>ISBN</th><th>Titulo</th><th>Categoria</th></tr>");
		
		for(Libro libro: listaLibros) {
			out.println(
					"<tr><td>" + 
					libro.getIsbn() + "</td><td>" +
					libro.getTitulo() + "</td><td>" + 
					libro.getCategoria() + "</td><td>" +
					"<a href='?accion=borrarlibro&isbn=" + libro.getIsbn() + "'>borrar</a></td>" +
					"</tr>"
			);
		}
		out.println("</table>");

	%>

	<a href = "?accion=formularionuevolibro">Nuevo</a>
</body>
	
	<script>
		const categoria = document.querySelector("#categoria");
		categoria.addEventListener('change', (e) => {
			const temp = e.target.value;
			location.href = `?accion=filtrocategorialibro&categoria=` + temp;
		})
	</script>
</html>