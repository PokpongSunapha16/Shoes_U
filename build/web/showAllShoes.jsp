<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Shoes"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Shoes Page</title>
    </head>
    <body>
        <h2>Show All Shoes</h2>
        <%
            ArrayList<Shoes> shoez = (ArrayList<Shoes>) session.getAttribute("shoez");
            if (shoez != null && !shoez.isEmpty()) {
                for (Shoes shoes : shoez) {
                    out.println("<b>ID:</b> " + shoes.getId() + "<br/>");
                    out.println("<b>Name:</b> " + shoes.getName() + "<br/>");
                    out.println("<b>Type:</b> " + shoes.getType() + "<br/>");
                    out.println("<b>Brand:</b> " + shoes.getBrand() + "<br/>");
                    out.println("<b>Price:</b> " + shoes.getPrice() + " Baht<br/>");
                    out.println("<hr/>");
                }
            } else {
                out.println("Haven't Any Shoes In Web App");
            }
        %>
    </body>
</html>
