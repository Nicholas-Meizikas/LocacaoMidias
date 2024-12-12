<%-- 
    Document   : novo
    Created on : 12 de dez. de 2024, 13:14:06
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
        
        <h1>Nova Midia</h1>

        <form method="post" action="${cp}/processaMidia">

          <input name="acao" type="hidden" value="inserir"/>

          <table>
            <tr>
              <td class="alinharDireita">Titulo:</td>
              <td>
                <input name="titulo"
                       type="text"
                       required/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Ano de Lançamento:</td>
              <td>
                <input name="anoLancamento"
                       type="text"
                       required/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Codigo de Barras:</td>
              <td>
                <input name="codigoBarras"
                       type="text"
                       required/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Duração em Minutos:</td>
              <td>
                <input name="duracao"
                       type="number"
                       required/>
              </td>
            </tr>
            <tr>
                <td class="alinharDireita">Ator Principal:</td>
                <td>

                    <jsp:useBean 
                        id="atorServicos"
                        scope="page"
                        class="locacaomidias.servicos.AtorServices"/>
                    <jsp:useBean 
                        id="generoServicos"
                        scope="page"
                        class="locacaomidias.servicos.GeneroServices"/>
                    <jsp:useBean 
                        id="classEServicos"
                        scope="page"
                        class="locacaomidias.servicos.ClassificacaoEtariaServices"/>
                    <jsp:useBean 
                        id="classIServicos"
                        scope="page"
                        class="locacaomidias.servicos.ClassificacaoInternaServices"/>
                    <jsp:useBean 
                        id="tipoServicos"
                        scope="page"
                        class="locacaomidias.servicos.TipoServices"/>


                    <select name="idAtorPrincipal" required>
                      <c:forEach items="${atorServicos.todos}" var="ator">
                        <option value="${ator.id}">
                          ${ator.nome} ${ator.sobrenome}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Ator Coadjuvante:</td>
                <td>
                    <select name="idAtorCoadjuvante" required>
                      <c:forEach items="${atorServicos.todos}" var="ator">
                        <option value="${ator.id}">
                          ${ator.nome} ${ator.sobrenome}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Genero:</td>
                <td>
                    <select name="idGenero" required>
                      <c:forEach items="${generoServicos.todos}" var="genero">
                        <option value="${genero.id}">
                          ${genero.descricao}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Classificação Etaria:</td>
                <td>
                    <select name="idClassEtaria" required>
                      <c:forEach items="${classEServicos.todos}" var="classE">
                        <option value="${classE.id}">
                          ${classE.descricao}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Classificação Interna:</td>
                <td>
                    <select name="idClassInterna" required>
                      <c:forEach items="${classIServicos.todos}" var="classI">
                        <option value="${classI.id}">
                          ${classI.descricao}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Tipo:</td>
                <td>
                    <select name="idTipo" required>
                      <c:forEach items="${tipoServicos.todos}" var="tipo">
                        <option value="${tipo.id}">
                          ${tipo.descricao}
                        </option>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
              <td>
                <a href="${cp}/formularios/midias/listagem.jsp">Voltar</a>
              </td>
              <td class="alinharDireita">
                <input type="submit" value="Salvar"/>
              </td>
            </tr>
          </table>

        </form>
          
    </body>
</html>
