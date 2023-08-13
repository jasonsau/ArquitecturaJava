<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.js.arquictecturajava.Libros" %>
<%@ page import="com.js.arquictecturajava.Categoria" %>

<%
    Libros libro = new Libros();
    List<Libros> libros = (List<Libros>) request.getAttribute("libros");
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<body>

<form action= "Filtrar.do">
    <select name = "categoria">
        <option value = "seleccionar"> seleccionar </option>
        <% for(Categoria categoria: categorias)
            if(categoria.getId().equals(request.getParameter("categoria"))) {
        %>
                <option value="<%=categoria.getId()%>" selected><%=categoria.getDescripcion()%></option>
            <%}else {%>
                    <option value = "<%=categoria.getId()%>"><%=categoria.getDescripcion()%></option>
            <%}%>
    </select>
    <input value ="filtrar" type="submit">
</form>


<%
    for (Libros book: libros) {
%>
    <%=book.getIsbn()%>
    <%=book.getTitulo()%>
    <%=book.getCategoria().getDescripcion()%>
<a href = "BorrarLibro.do?isbn=<%=book.getIsbn()%>">Borrar Libro</a>
<a href="FormularioEditarLibro.do?isbn=<%=book.getIsbn()%>">Editar Libro</a>
<br>
<%
    }%>

</body>

<a href = "FormularioInsertarLibro.do">Insertar Libro</a>
