package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderDaoImpl {
    public CustomerDTO searchItem(String newValue) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(
                newValue + "",
                rst.getString("name"),
                rst.getString("address"));

        return customerDTO;


    }
}
