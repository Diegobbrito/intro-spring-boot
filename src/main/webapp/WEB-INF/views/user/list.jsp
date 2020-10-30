 <%@ page contentType="text/html;charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Lista de Usuarios</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css}"/>
</head>
<body>

<div class="container">
    <h1>Lista de Usuarios</h1>
    <hr>
</div>
<div>
    <spring:url value="/usuario/cadastro" var="cadastro"/>
    <a class="btn btn-info" href="${cadastro}">Novo Usuário</a>
</div>
<hr>

<div class="card ${message == null ? '&nbsp;' : message}">
    <div class="panel-heading">
        <span>${message == null ? '&nbsp;' : message}</span>
    </div>
    <table class="table table-striped table-condensed">
        <thead>
        <tr>
            <th>ID</th>
            <th>NOME</th>
            <th>DATA NASCIMENTO</th>
            <th>SEXO</th>
            <th>AÇÃO</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome }&nbsp;${usuario.sobrenome}</td>
                    <td>
                        <f:parseDate var="date" value="${usuario.dtNascimento}" pattern="yyyy-MM-dd" type="date"/>
                        <f:formatDate value="${date}" pattern="dd/MM/yyyy" type="date" />
                    </td>
                    <td>${usuario.sexo.desc}</td>
                    <td>
                        <spring:url value="/usuario/update/${usuario.id}" var="update"/>
                        <a class="btn btn-info" href="${update}">Editar</a>
                        <spring:url value="/usuario/delete/${usuario.id}" var="delete"/>
                        <a class="btn btn-danger" href="${delete}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<footer class="footer">

</footer>
</body>
</html>
