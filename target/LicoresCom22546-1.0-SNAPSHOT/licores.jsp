<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Licores</title>
    </head>
    <body>
        <h1>Lista de licores</h1>
        <ul>
            <c:forEach var="licor" items= "${licores}">
                <li> ${licor.idlicor} ${licor.tipo} ${licor.marca} </li>
            </c:forEach>
        </ul>
            
    </body>
</html>
