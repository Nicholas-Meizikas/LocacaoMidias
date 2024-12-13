<%-- 
    Document   : novo
    Created on : 13 de dez. de 2024, 10:27:53
    Author     : nicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novos Exemplares</title>
    </head>
    <body>
        <h1>Novo Exemplar</h1>
        <form method="post" action="${cp}/pExemplar">

        <input name="acao" type="hidden" value="inserir"/>

        <table>
            <tr>
                <td class="alinharDireita">Numero de exemplares a cadastrar:</td>
                <td>
                    <input name="quantidade"
                           type="number"
                           required/>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Midia:</td>
                <td>

                    <jsp:useBean 
                        id="servicos"
                        scope="page"
                        class="locacaomidias.servicos.MidiaServices"/>

                    <select name="idMidia" required>
                        <c:forEach items="${servicos.todos}" var="midia">
                            <option value="${midia.id}">
                                ${midia.titulo}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td>
                    <a href="${cp}/formularios/exemplares/listagem.jsp">Voltar</a>
                </td>
                <td class="alinharDireita">
                    <input type="submit" value="Salvar"/>
                </td>
            </tr>
        </table>

    </form>
    </body>
</html>
