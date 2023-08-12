<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.js.arquictecturajava.Libros" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Libro</title>
</head>
<%
    List<String> categorias = (List<String>) request.getAttribute("categorias");
    Libros libro = (Libros) request.getAttribute("libro");
%>
<%=libro.getCategoria()%>
<body>
<form action = "ModificarLibro.do">
    <fieldset>
        <legend>Formulario alta libro</legend>
        <p>
            <label for = "isbn">ISBN:</label>
            <input id = "isbn" type = "text" name = "isbn" value = "<%=libro.getIsbn()%>">
        </p>
        <p>
            <label for = "titulo">Titulo:</label>
            <input id = "titulo" type = "text" name = "titulo" value = "<%=libro.getTitulo()%>">
        </p>
        <p>
            <label for = "categoria">Categoria: </label>
            <select id = "categoria" name = "categoria">
                <option>Seleccione una</option>
                <% for(String categoria: categorias) {
                    if(categoria.equals(libro.getCategoria())) {%>
                        <option value="<%=categoria%>" selected><%=categoria%></option>
                    <%} else {%>
                        <option value="<%=categoria%>" ><%=categoria%></option>

                <%}}%>
            </select>
        </p>
        <input type="submit" value="Editar"/>
    </fieldset>
</form>
</body>
</html>
