<%-- 
    Document   : excluir
    Created on : 12 de dez. de 2024, 10:35:23
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Ator</title>
    </head>
    <body>
        <h1>Excluir Ator/Atriz</h1>

        <form method="post" action="${cp}/processaAtor">

          <input name="acao" type="hidden" value="excluir"/>
          <input name="id" type="hidden" value="${requestScope.ator.id}"/>

          <table>
            <tr>
              <td class="alinharDireita">nome:</td>
              <td>${requestScope.ator.nome} ${requestScope.ator.sobrenome}</td>
            </tr>
            <tr>
              <td class="alinharDireita">Data de Estreia:</td>
              <td>${requestScope.ator.dataEstreia}</td>
            </tr>
            <tr>
              <td>
                <a href="${cp}/formularios/ator/listagem.jsp">Voltar</a>
              </td>
              <td class="alinharDireita">
                <input type="submit" value="Excluir"/>
              </td>
            </tr>
          </table>

        </form>
    </body>
</html>
