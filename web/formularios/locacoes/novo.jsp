<%-- 
    Document   : novo
    Created on : 13 de dez. de 2024, 13:15:02
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
        <title>Alugando</title>
    </head>
    <body>
        <h1>Novo Aluguel</h1>
        <form method="post" action="${cp}/pLocacao">
            <jsp:useBean
                id="ClienteServicos"
                scope="page"
                class="locacaomidias.servicos.ClienteServices"/>
            <jsp:useBean
                id="ExemplarServicos"
                scope="page"
                class="locacaomidias.servicos.ExemplaresServices"/>
            
            <input name="acao" type="hidden" value="inserir"/>
            
            <table>
                <tr>
                    <td class="alinharDireita">Cliente:</td>
                    <td>
                        <select name="idCliente" required>
                            <c:forEach items="${ClienteServicos.todos}" var="cliente">
                                <option value="${cliente.id}">
                                    ${cliente.nome} ${cliente.sobrenome}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">filme:</td>
                    <td>
                        <select name="idExemplar" required>
                            <c:forEach items="${ExemplarServicos.todos}" var="exemplar">
                                <c:choose>
                                    <c:when test="${exemplar.disponivel}">
                                        <option value="${exemplar.id}">
                                            ${exemplar.midia.titulo}
                                        </option>
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Valor:</td>
                    <td>
                        <input name="valor" 
                               type="number"
                               required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/locacoes/listagem.jsp">
                            Voltar
                        </a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>
        
        </form>
    </body>
</html>
