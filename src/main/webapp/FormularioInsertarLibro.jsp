<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Insertar Libro</title>
</head>
<%
  List<String> categorias = (List<String>) request.getAttribute("categorias");
%>
<body>
  <form action = "InsertarLibro.do">
    <fieldset>
      <legend>Formulario alta libro</legend>
      <p>
        <label for = "isbn">ISBN:</label>
        <input id = "isbn" type = "text" name = "isbn">
      </p>
      <p>
        <label for = "titulo">Titulo:</label>
        <input id = "titulo" type = "text" name = "titulo">
      </p>
      <p>
        <label for = "categoria">Categoria: </label>
        <select id = "categoria" name = "categoria">
          <option>Seleccione una</option>
          <% for(String categoria: categorias) { %>
            <option value="<%=categoria%>"><%=categoria%></option>
          <%}%>
        </select>
      </p>
      <input type="submit" value="Guardar"/>
    </fieldset>
  </form>
</body>
</html>