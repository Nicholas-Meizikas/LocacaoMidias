<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="pLocacao?acao=preparar"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Listar Alugueis</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

      <h1>Aluguéis Cadastrados</h1>

    <p>
      <a href="${cp}/formularios/locacoes/novo.jsp">
        Novo aluguel
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Cliente</th>
          <th>Filme</th>
          <th>valor</th>
          <th>Data de Inicio</th>
          <th>Data de devolução</th>
          <th>Devolvido</th>
          <th>Devolver</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean 
            id="servicos"
            scope="page"
            class="locacaomidias.servicos.ItemLocacaoServices"/>

        <c:forEach items="${servicos.todos}" var="alugado">
          <tr>
            <td>${alugado.locacao.cliente.nome} ${alugado.locacao.cliente.sobrenome}</td>
            <td>${alugado.exemplar.midia.titulo}</td>
            <td>${alugado.valor}</td>
            <td>${alugado.locacao.dataInicio}</td>
            <td>${alugado.locacao.dataFim}</td>
            <td>${alugado.locacao.cancelada}</td>
            <td>
                <c:choose>
                    <c:when test="${alugado.locacao.cancelada}">
                        Devolvido
                    </c:when>
                    <c:otherwise>
                        <a href="${cp}/${prefixo}Alteracao&idLocacao=${alugado.locacao.id}&idExemplar=${alugado.exemplar.id}">
                            Devolvido
                        </a>
                    </c:otherwise>
                </c:choose>
              
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&idLocacao=${alugado.locacao.id}&idExemplar=${alugado.exemplar.id}">
                Excluir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
      
    </table>

    <p>
      <a href="${cp}/formularios/locacoes/novo.jsp">
        Novo aluguel
      </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
