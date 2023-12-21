package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlaceOderDaoImpl {
    public boolean saveorderDetail(String oid, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        preparedStatement.setString(1,oid);
        preparedStatement.setString(2,orderDetailDTO.getItemCode());
        preparedStatement.setBigDecimal(3,orderDetailDTO.getUnitPrice());
        preparedStatement.setInt(4,orderDetailDTO.getQty());
        int i = preparedStatement.executeUpdate();
        return i>0;

    }
}
