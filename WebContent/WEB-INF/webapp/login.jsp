<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<c:if test="${not empty usuarioLogado}">
	Logado como : ${usuarioLogado.email}</br>
</c:if>

<c:if test="${empty usuarioLogado}">
	Usuario Invalido.</br>
</c:if>
</body>
</html>