<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.js.arquictecturajava.Libros" %>

<%
    Libros libro = new Libros();
    List<Libros> libros = (List<Libros>) request.getAttribute("libros");
    List<String> categorias = (List<String>) request.getAttribute("categorias");
%>
<body>

<form action= "Filtrar.do">
    <select name = "categoria">
        <option value = "seleccionar"> seleccionar </option>
        <% for(String categoria: categorias)
            if(categoria.equals(request.getParameter("categoria"))) {
        %>
                <option value="<%=categoria%>" selected><%=categoria%></option>
            <%}else {%>
                    <option value = "<%=categoria%>"><%=categoria%></option>
            <%}%>
    </select>
    <input value ="filtrar" type="submit">
</form>


<%
    for (Libros book: libros) {
%>
    <%=book.getIsbn()%>
    <%=book.getTitulo()%>
    <%=book.getCategoria()%>
<a href = "BorrarLibro.do?isbn=<%=book.getIsbn()%>">Borrar Libro</a>
<a href="FormularioEditarLibro.do?isbn=<%=book.getIsbn()%>">Editar Libro</a>
<br>
<%
    }%>

</body>

<a href = "FormularioInsertarLibro.do">Insertar Libro</a>
