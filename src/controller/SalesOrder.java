package controller;

import database.DbConnection;
import helper.AlertHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class SalesOrder {

    @FXML
    private TextField orderId;

    @FXML
    private TextField orderDate;

    @FXML
    private TextField shipDate;

    @FXML
    private TextField shipMode;

    @FXML
    private TextField customerID;

    @FXML
    private TextField customerName;

    @FXML
    private TextField segment;

    @FXML
    private TextField city;

    @FXML
    private TextField state;

    @FXML
    private TextField region;

    @FXML
    private TextField productID;

    @FXML
    private TextField productName;

    @FXML
    private TextField category;

    @FXML
    private TextField subCategory;

    @FXML
    private TextField sales;

    @FXML
    private TextField quantity;

    @FXML
    private TextField discount;

    @FXML
    private TextField profit;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws SQLException {

        DbConnection dbc = DbConnection.getDatabaseConnection();
        Connection con = dbc.getConnection();

        Statement stmt = con.createStatement();

        Window owner = submitButton.getScene().getWindow();

        String addSalesOrderQuery = "INSERT INTO sales_orders(order_id, order_date, ship_date, ship_mode, customer_id, customer_name, segement,"
                + "city, state, region, product_id, category, sub_category, product_name, sales, quantity, discount, profit) "
                + "VALUES('" + orderId.getText() + "','" + orderDate.getText() + "','" + shipDate.getText() + "','" + shipMode.getText() + "','" + customerID.getText() + "','" + customerName.getText() + "','"
                + segment.getText() + "','" + city.getText() + "','" + state.getText() + "','" + region.getText() + "','" + productID.getText() + "','" + productName.getText() + "','"
                + category.getText() + "','" + subCategory.getText() + "'," + sales.getText() + "," + quantity.getText() + "," + discount.getText() + "," + profit.getText() + ")";

        System.out.println(addSalesOrderQuery);

        int rs = stmt.executeUpdate(addSalesOrderQuery);

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Information",
                "Order no " + orderId.getText() + " saved successfully.");
        this.clearForm();

    }

    private void clearForm() {
        orderId.clear();
        orderDate.clear();
        shipDate.clear();
        shipMode.clear();
        customerID.clear();
        customerName.clear();
        segment.clear();
        city.clear();
        state.clear();
        region.clear();
        productID.clear();
        productName.clear();
        category.clear();
        subCategory.clear();
        sales.clear();
        quantity.clear();
        discount.clear();
        profit.clear();
    }
}
