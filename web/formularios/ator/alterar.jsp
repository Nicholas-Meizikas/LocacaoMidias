<%-- 
    Document   : alterar
    Created on : 12 de dez. de 2024, 10:11:30
    Author     : nicho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alterar Ator</h1>

        <form method="post"  action="${cp}/processaAtor">

          <input name="acao" type="hidden" value="alterar"/>
          <input name="id" type="hidden" value="${requestScope.ator.id}"/>

          <table>
            <tr>
              <td class="alinharDireita">Nome:</td>
              <td>
                <input name="nome"
                       type="text"
                       size="20"
                       maxlength="30"
                       required
                       value="${requestScope.ator.nome}"/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Sobrenome:</td>
              <td>
                <input name="sobrenome"
                       type="text"
                       size="20"
                       maxlength="30"
                       required
                       value="${requestScope.ator.sobrenome}"/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Data de Estreia:</td>
              <td>
                  <input
                      name="dataEstreia"
                      type="date"
                      required
                      value="${requestScope.ator.dataEstreia}">
              </td>
            </tr>
            <tr>
              <td>
                <a href="${cp}/formularios/ator/listagem.jsp">Voltar</a>
              </td>
              <td class="alinharDireita">
                <input type="submit" value="Alterar"/>
              </td>
            </tr>
          </table>
        </form>
    </body>
</html>
