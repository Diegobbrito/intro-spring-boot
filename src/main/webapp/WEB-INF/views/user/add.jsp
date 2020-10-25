<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<div class="container">
    <h1>Cadastro de Usuarios</h1>
    <hr>

<div>
    <spring:url value="/usuario/todos" var="home"/>
    <a class="btn btn-default" href="${home}">Lista de usuários</a>
</div>
<hr>
<div>
    <spring:url value="/usuario/save" var="save"/>
    <form:form  modelAttribute="usuario" action="${save}" method="post">
        <div class="form-group">
            <label for="nome">Nome: </label>
            <form:input path="nome" class="form-control" />
        </div>
        <div class="form-group">
            <label for="sobrenome">Sobrenome: </label>
            <form:input path="sobrenome" class="form-control" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Confirmar</button>
        </div>
    </form:form>
</div>
</div>
</body>
</html>
