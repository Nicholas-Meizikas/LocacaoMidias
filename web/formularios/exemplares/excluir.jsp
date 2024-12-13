<%-- 
    Document   : excluir
    Created on : 13 de dez. de 2024, 10:50:37
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
        <title>Excluir Exemplar</title>
    </head>
    <body>
        <h1>Excluir Cidade</h1>

        <form method="post" action="${cp}/pExemplar">

          <input name="acao" type="hidden" value="excluir"/>
          <input name="id" type="hidden" value="${requestScope.exemplar.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Disponível:</td>
                    <td>${requestScope.exemplar.disponivel}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Titulo:</td>
                    <td>${requestScope.exemplar.midia.titulo}</td>
                </tr>
                <tr>
                    <td>
                      <a href="${cp}/formularios/exemplares/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                      <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
