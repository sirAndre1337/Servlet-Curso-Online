<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Gerenciador</title>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Logado como : ${usuarioLogado.email}</br>
</c:if>

<form action="executa" method="post"/>
					  <input type="hidden" name="tarefa" value="NovaEmpresa">
	Nome da empresa : <input type="text" name="nome"/>
					  <input type="submit" value="Cadastrar"/>

</form>



<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="Login">
	Email : <input type="text" name="email"/> </br>
	Senha :	<input type="text" name="senha"/>   
			<input type="submit" value="Enviar"/>
</form>

<form action="executa" method="post">
	<input type="hidden" name="tarefa" value="Logout">
	Deslogar : <input type="submit" value="Deslogar">
</form>
</body>
</html>