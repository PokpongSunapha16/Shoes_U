<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Shoes" %>
<%@page import="java.util.*" %>
<%
    Shoes shoes = (Shoes) session.getAttribute("shoes");
    String brand = shoes.getBrand();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Shoes Page</title>
    </head>
    <body>
        <h1>Edit Shoes</h1>

        <form action="AddNewShoesServlet" method="post">
            Name: <input type="text" name="shoesName" value="<%= shoes.getName() %>"><br/><br/>

            Type:
            <select name="shoesType">
                <option value="balance" <%= shoes.getType().equals("balance") ? "selected" : "" %>>Balance</option>
                <option value="soft" <%= shoes.getType().equals("soft") ? "selected" : "" %>>Soft</option>
                <option value="bounce" <%= shoes.getType().equals("bounce") ? "selected" : "" %>>Bounce</option>
            </select><br/><br/>

            Brand :<br/>
            <input type="radio" name="brand" value="nike" <%= brand.equals("nike") ? "checked" : "" %>> NIKE<br/>
            <input type="radio" name="brand" value="adidas" <%= brand.equals("adidas") ? "checked" : "" %>> ADIDAS<br/>
            <input type="radio" name="brand" value="puma" <%= brand.equals("puma") ? "checked" : "" %>> PUMA<br/><br/>

            Price: <input type="text" name="shoesPrice" value="<%= shoes.getPrice() %>"><br/><br/>

            <input type="submit" value="SAVE">
        </form>

        <% session.removeAttribute("shoes"); %>
    </body>
</html>
