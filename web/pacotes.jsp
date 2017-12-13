<%-- 
    Document   : pacotes
    Created on : 05/11/2017, 16:21:09
    Author     : BRYAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacotes - Projeto 05</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link rel="stylesheet" href="css/css.css">
    </head>
    <body>
        <%@include file = "WEB-INF/jspf/header.jspf"%>
        <main class="container" style="margin-top: 8%;">
            <h2>PACOTES DISPONIVEIS</h2>
            <table class="table table-striped table-dark">
                <tr>
                    <th scope="col">ORIGEM</th>
                    <th scope="col">DATA DE IDA</th>
                    <th scope="col">DESTINO</th>
                    <th scope="col">DATA DE VOLTA</th>
                    <th scope="col">CATEGORIA</th>
                    <th scope="col">PREÇO</th>
                    <th scope="col">COMPRAR</th>
                    
                </tr>
                <tr scope="row">
                    <td>etw</td>
                    <td>etw</td>
                    <td>etw</td>
                    <td>etw</td>
                    <td>etw</td>
                    <td>etw</td>
                    <td><a href="https://pagseguro.uol.com.br/#rmcl"><button class="btn align-middle btn-light">Comprar </button></a></td>
                </tr>
            </table>
        </main>
        <%@include file= "WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
