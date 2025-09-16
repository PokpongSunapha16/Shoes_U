<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Shoes" %>
<%@page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Add Shoes Success</h1>
                <%
                    Shoes shoes = (Shoes) session.getAttribute("shoes");
                %>
                Name : <%= shoes.getName() %><br/>
                Type: <%= shoes.getType() %><br/>
                Brand : <%= shoes.getBrand() %><br/>
                Price : <%= shoes.getPrice() %> Baht<br/>
        <a href="UpdateShoes.jsp">CLICK HERE TO EDIT</a>
    </body>
</html>
