<%@ page isErrorPage="true"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
</head>
<body>
Ha ocurrido un error en la aplicacion: <%=exception.getMessage()%>
Error Interno <%=exception.getCause().getMessage()%>

</body>
</html>
