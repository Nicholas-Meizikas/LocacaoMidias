<%-- 
    Document   : excluir
    Created on : 13 de dez. de 2024, 13:16:54
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
        <title>Excluir Aluguel</title>
    </head>
    <body>
        <h1>Deletar Locação</h1>
        
        <form method="post" action="${cp}/pLocacao">

          <input name="acao" type="hidden" value="excluir"/>
          <input name="idLocacao" type="hidden" value="${requestScope.itemLocacao.locacao.id}"/>
          <input name="idExemplar" type="hidden" value="${requestScope.itemLocacao.exemplar.id}"/>

          <table>
            <tr>
              <td class="alinharDireita">nome:</td>
              <td>${itemLocacao.locacao.cliente.nome} ${itemLocacao.locacao.cliente.sobrenome}</td>
            </tr>
            <tr>
              <td class="alinharDireita">Devolvida:</td>
              <td>${itemLocacao.locacao.cancelada}</td>
            </tr>
            <tr>
              <td class="alinharDireita">Data de Inicio:</td>
              <td>${itemLocacao.locacao.dataInicio}</td>
            </tr>
            <tr>
              <td class="alinharDireita">Data de Fim:</td>
              <td>${itemLocacao.locacao.dataFim}</td>
            </tr>
            <tr>
              <td class="alinharDireita">Filme:</td>
              <td>${itemLocacao.exemplar.midia.titulo}</td>
            </tr>
            <tr>
              <td>
                <a href="${cp}/formularios/locacoes/listagem.jsp">Voltar</a>
              </td>
              <td class="alinharDireita">
                <input type="submit" value="Excluir"/>
              </td>
            </tr>
          </table>

        </form>
        
    </body>
</html>
