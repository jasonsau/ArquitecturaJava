<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "web1.models.Categoria" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Formulario de Libro</title>
	</head>
	<body>
		<h2>Formulario de Libro</h2>
		<form method="POST" action="?accion=insertarlibro">
			<label for="isbn">ISBN:</label>
			<input type="text" name="isbn" required><br>
			<label for="titulo">Titulo:</label>
			<input type="text" name="titulo" required><br>
			<label for="categoria">Categoria:</label>
			<%				
				try {
					List<Categoria> categorias =(List<Categoria>) request.getAttribute("listaCategorias");
					out.println("<select name = 'categoria' id = 'categoria'>");
					for(Categoria categoria: categorias) {
						out.println("<option value = '" + categoria.getId() + "'>"+categoria.getNombre()+"</option>");
					}
					out.println("</select>");
				}catch(Exception e) {
					out.println("<p>Error al obtener las categorias</p>");
					e.printStackTrace();
				}

			%><br>
			<input type="submit" value="Guardar Libro">
		</form>
	</body>

</html>