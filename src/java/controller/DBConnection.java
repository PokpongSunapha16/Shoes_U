package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;
import java.util.List;
import model.Shoes;

public class DBConnection {

public boolean insertNewShoes(Shoes shoes) {
    boolean result = false;
    Connection connection = null;
    try {
        // below two lines are used for connectivity.
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shoesU",
                "root", "1234");

        Statement statement;
        statement = connection.createStatement();

        String query = "INSERT INTO shoes "
                + "(name, type, brand, price) "
                + "VALUES('"
                + shoes.getName() + "','"
                + shoes.getType() + "','"
                + shoes.getBrand() + "',"
                + shoes.getPrice() + ")";
        System.out.println("........SQL: " + query);

        int i = statement.executeUpdate(query); // executeUpdate returns row count
        if (i != 0) {
            result = true;
        }
        statement.close();
        connection.close();
    } catch (Exception exception) {
        System.out.println(exception);
    }

    return result;
}


  public List<Shoes> retrieveAllShoes() {

    List<Shoes> shoez = new ArrayList();

    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shoesU",
                "root", "1234");

        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery("select * from shoes");

        String id, name, type, brand;
        int price;

        while (resultSet.next()) {
            Shoes shoes = new Shoes();

            id = String.valueOf(resultSet.getInt("id"));
            name = resultSet.getString("name").trim();
            type = resultSet.getString("type").trim();
            brand = resultSet.getString("brand").trim();
            price = resultSet.getInt("price");

            shoes.setId(id);
            shoes.setName(name);
            shoes.setType(type);

            shoes.setBrand(brand);
            shoes.setPrice(price);

            shoez.add(shoes);
        }

        // close DB connection
        resultSet.close();
        statement.close();
        connection.close();

    } catch (Exception exception) {
        System.out.println(exception);
    }

    // return List<Food>
    return shoez;
}



    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
public void testRetrieve() {
    Connection connection = null;
    try {
        // below two lines are used for connectivity.
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shoesU",
                "root", "1234");

        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery("select * from shoes");

        String id, name, type, brand;
        int price;

        while (resultSet.next()) {
            id = String.valueOf(resultSet.getInt("id"));
            name = resultSet.getString("name").trim();
            type = resultSet.getString("type").trim();
            brand = resultSet.getString("brand").trim();
            price = resultSet.getInt("price");

            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Type: " + type);
            System.out.println("Brand: " + brand);
            System.out.println("Price: " + price);
            System.out.println("----------------------------");
        }

        resultSet.close();
        statement.close();
        connection.close();

    } catch (Exception exception) {
        System.out.println(exception);
    }
}

}
