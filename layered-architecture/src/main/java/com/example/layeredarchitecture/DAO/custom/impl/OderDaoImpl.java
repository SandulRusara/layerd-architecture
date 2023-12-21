package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.custom.OderDao;
import com.example.layeredarchitecture.DAO.sqlUtil;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;


public class OderDaoImpl implements OderDao {
    @Override
    public String genarateNewOderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = sqlUtil.text("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return resultSet.next() ? String.format("OID-%03d", (Integer.parseInt(resultSet.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean checkOderId(String orderId) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
//        stm.setString(1, orderId);
       ResultSet resultSet =  sqlUtil.text("SELECT oid FROM `Orders` WHERE oid=?",orderId);
       return resultSet.next();
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save( OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        return sqlUtil.text("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderDTO.getOrderId(),orderDTO.getOrderDate(),orderDTO.getCustomerId());
//        preparedStatement.setString(1,orderDTO.getOrderId());
//        preparedStatement.setDate(2, Date.valueOf(orderDTO.getOrderDate()));
//        preparedStatement.setString(3,orderDTO.getCustomerId());
//        int i = preparedStatement.executeUpdate();
//        return i>0;
    }

    @Override
    public boolean Update(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exite(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


}
