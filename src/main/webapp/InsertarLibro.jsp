<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
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
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3003/biblioteca";
			String usuario = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (
					Connection connection = DriverManager.getConnection(jdbcUrl, usuario, password);
					PreparedStatement preparedStatement = connection.prepareStatement(
							"INSERT INTO libros(isbn, titulo, categoria) VALUES (?,?,?)"
							)
					) {
				
				preparedStatement.setString(1, isbn);
				preparedStatement.setString(2, titulo);
				preparedStatement.setString(3, categoria);
				
				preparedStatement.executeUpdate();
				response.sendRedirect("listalibros.jsp");
				
			} catch (SQLException e) {
				out.println("<p>Error al insertar el libro</p>");
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			out.println("<p>Error al procesar el formulario</p>");
			e.printStackTrace();
		}
	%>
	
</body>
</html>