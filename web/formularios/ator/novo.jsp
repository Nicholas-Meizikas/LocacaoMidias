<%-- 
    Document   : novo
    Created on : 12 de dez. de 2024, 10:04:38
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
        <title>Novo Ator</title>
    </head>
    <body>
        
        <h1>Novo Ator/Atriz</h1>

        <form method="post" action="${cp}/processaAtor">

          <input name="acao" type="hidden" value="inserir"/>

          <table>
            <tr>
              <td class="alinharDireita">Nome:</td>
              <td>
                <input name="nome"
                       type="text"
                       size="20"
                       maxlength="30"
                       required/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Sobrenome:</td>
              <td>
                <input name="sobrenome"
                       type="text"
                       size="20"
                       maxlength="30"
                       required/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">data de Estreia:</td>
              <td>
                  <input name="dataEstreia"
                         type="date"
                         placeholder="dd/mm/yyyy"
                         required/>
              </td>
            </tr>
            <tr>
              <td>
                <a href="${cp}/formularios/ator/listagem.jsp">Voltar</a>
              </td>
              <td class="alinharDireita">
                <input type="submit" value="Salvar"/>
              </td>
            </tr>
          </table>

        </form>
          
    </body>
</html>
