<%@ page import="java.sql.*" %>

<html>
<body>

    <%
        final String DB_NAME = "beverage";
        final String USER = "root";
        final String PASS = "";
        final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

        String options = "";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful.");
        } catch (Exception e) {
            System.out.println("ERROR: Connection to database failed!!!");
            e.printStackTrace();
        }

        String query = "SELECT * FROM beverages";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String drinkName = resultSet.getString("drink_name");
            int rate = resultSet.getInt("rate");
            options += "<option>" + drinkName + " - $" + rate + "</option>";
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>

<select>
    <option>Select a Drink</option>
    <%= options %>
</select>

</body>
</html>