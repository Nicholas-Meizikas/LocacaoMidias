<%-- 
    Document   : excluir
    Created on : 12 de dez. de 2024, 13:14:20
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
        <h1>Excluir Cidade</h1>
        
        <form method="post" action="${cp}/processaMidia">
            
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.midia.id}"/>
            
            <table>
                <tr>
                    <td class="alinharDireita">Titulo:</td>
                    <td>${requestScope.midia.titulo}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Ano de lançamento:</td>
                    <td>${requestScope.midia.anoLancamento}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">codigo de Barras:</td>
                    <td>${requestScope.midia.codigoBarras}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Duração em Minutos:</td>
                    <td>${requestScope.midia.duracaoMinutos}</td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Ator Principal:</td>
                    <td>${requestScope.midia.principal.nome} ${requestScope.midia.principal.sobrenome}</td>
                </tr>    
                <tr>
                    <td class="alinharDireita">Ator Coadjuvante:</td>
                    <td>${requestScope.midia.coadjuvante.nome} ${requestScope.midia.coadjuvante.sobrenome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Genero:</td>
                    <td>${requestScope.midia.genero.descricao}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Classificação Etaria:</td>
                    <td>${requestScope.midia.classeEtaria.descricao}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Classificação Interna:</td>
                    <td>${requestScope.midia.classeInterna.descricao}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Tipo:</td>
                    <td>${requestScope.midia.tipo.descricao}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formularios/midias/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>        
        </form>
    </body>
</html>
