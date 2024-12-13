<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaMidia?acao=preparar"/>
<!DOCTYPE html>

<html>
  <head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

      <h1>Exemplares Cadastrados</h1>

    <p>
      <a href="${cp}/formularios/exemplares/novo.jsp">
        Novo Exemplar
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Id</th>
          <th>Disponívle</th>
          <th>titulo</th>
          <th>Alterar</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaomidias.servicos.ExemplaresServices"/>

        <c:forEach items="${servicos.todos}" var="exemplar">
          <tr>
            <td>${exemplar.id}</td>
            <td>${exemplar.disponivel}</td>
            <td>${exemplar.midia.titulo}</td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${midia.id}">
                Alterar
              </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${midia.id}">
                Excluir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <p>
      <a href="${cp}/formularios/exemplares/novo.jsp">
        Novos Exemplares
      </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
