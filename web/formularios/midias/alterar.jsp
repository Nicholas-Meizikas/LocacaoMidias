<%-- 
    Document   : alterar
    Created on : 12 de dez. de 2024, 13:14:13
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
        <h1>Alterar Midia</h1>

        <form method="post" action="${cp}/processaMidia">

          <input name="acao" type="hidden" value="alterar"/>
          <input name="id" type="hidden" value="${requestScope.midia.id}"/>

          <table>
            <tr>
              <td class="alinharDireita">Titulo:</td>
              <td>
                <input name="titulo"
                       type="text"
                       required
                       value="${requestScope.midia.titulo}"/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Ano de Lançamento:</td>
              <td>
                <input name="anoLancamento"
                       type="text"
                       required
                       value="${requestScope.midia.anoLancamento}"/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Codigo de Barras:</td>
              <td>
                <input name="codigoBarras"
                       type="text"
                       required
                       value="${requestScope.midia.codigoBarras}"/>
              </td>
            </tr>
            <tr>
              <td class="alinharDireita">Duração em Minutos:</td>
              <td>
                <input name="duracao"
                       type="number"
                       required
                       value="${requestScope.midia.duracaoMinutos}"/>
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
                            <c:choose>
                                <c:when test="${requestScope.midia.principal.id eq
                                                      ator.id}">
                                        
                                        <option value="${ator.id}" selected>
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${ator.id}">
                                        ${ator.nome} ${ator.sobrenome}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Ator Coadjuvante:</td>
                <td>
                    <select name="idAtorCoadjuvante" required>
                      <c:forEach items="${atorServicos.todos}" var="ator">
                            <c:choose>
                                <c:when test="${requestScope.midia.coadjuvante.id eq
                                                      ator.id}">
                                        
                                        <option value="${ator.id}" selected>
                                            ${ator.nome} ${ator.sobrenome}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${ator.id}">
                                        ${ator.nome} ${ator.sobrenome}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Genero:</td>
                <td>
                    <select name="idGenero" required>
                      <c:forEach items="${generoServicos.todos}" var="genero">
                            <c:choose>
                                <c:when test="${requestScope.midia.genero.id eq
                                                      genero.id}">
                                        <option value="${genero.id}" selected>
                                            ${genero.descricao}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${genero.id}" >
                                            ${genero.descricao}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Classificação Etaria:</td>
                <td>
                    <select name="idClassEtaria" required>
                      <c:forEach items="${classEServicos.todos}" var="classE">
                            <c:choose>
                                <c:when test="${requestScope.midia.classeEtaria.id eq
                                                      classE.id}">
                                        <option value="${classE.id}" selected>
                                            ${classE.descricao}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${classE.id}" >
                                            ${classE.descricao}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Classificação Interna:</td>
                <td>
                    <select name="idClassInterna" required>
                      <c:forEach items="${classIServicos.todos}" var="classI">
                            <c:choose>
                                <c:when test="${requestScope.midia.classeInterna.id eq
                                                      classI.id}">
                                        <option value="${classI.id}" selected>
                                            ${classI.descricao}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${classI.id}" >
                                            ${classI.descricao}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                      </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="alinharDireita">Tipo:</td>
                <td>
                    <select name="idTipo" required>
                      <c:forEach items="${tipoServicos.todos}" var="tipo">
                        <c:choose>
                                <c:when test="${requestScope.midia.tipo.id eq
                                                      tipo.id}">
                                        <option value="${tipo.id}" selected>
                                            ${tipo.descricao}
                                        </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${tipo.id}" >
                                            ${tipo.descricao}
                                    </option>
                                </c:otherwise>
                            </c:choose>
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
