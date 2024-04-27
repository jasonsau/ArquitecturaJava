<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<%
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3003/biblioteca";
			String usuario = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (
					Connection connection = DriverManager.getConnection(jdbcUrl, usuario, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT *FROM libros");
					) {
				out.println("<h2>Lista de Libros</h2>");
				out.println("<table border ='1'>");
				out.println("<tr><th>ISBN</th><th>Titulo</th><th>Categoria</th></tr>");
				
				while(resultSet.next()) {
					String isbn = resultSet.getString("isbn");
					String titulo = resultSet.getString("titulo");
					String categoria = resultSet.getString("categoria");
					
					out.println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>");
				}
				out.println("</table>");
			} catch(SQLException e) {
				out.println("<p>Error al obtener la lista de libros");
				e.printStackTrace();
			}
		} catch(Exception e) {
			out.println("<p>Error al procesar la solicitud</p>");
			e.printStackTrace();
		}
	%>

	<a href = "formularionuevolibro.jsp">Nuevo</a>
</body>
</html>