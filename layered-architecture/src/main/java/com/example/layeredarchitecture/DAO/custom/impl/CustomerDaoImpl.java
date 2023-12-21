package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.custom.CustomerDao;
import com.example.layeredarchitecture.DAO.sqlUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ResultSet rst= sqlUtil.text("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomeres= new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO=new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
                     getAllCustomeres.add(customerDTO);
        }
        return getAllCustomeres;


    }
    @Override
    public boolean Save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?)");
//        pstm.setString(1,customerDTO.getId());
//        pstm.setString(2,customerDTO.getName());
//        pstm.setString(3, customerDTO.getAddress());
//        int i = pstm.executeUpdate();
//        return i>0;

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?)");
//        preparedStatement.setString(1,customerDTO.getId());
//        preparedStatement.setString(1,customerDTO.getName());
//        preparedStatement.setString(3,customerDTO.getAddress());
//
//        int i = preparedStatement.executeUpdate();
//        return i>0;
        return  sqlUtil.text("INSERT INTO Customer VALUES (?,?,?)");


    }
    @Override
    public boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        preparedStatement.setString(1,customerDTO.getName());
        preparedStatement.setString(2,customerDTO.getAddress());
        preparedStatement.setString(3,customerDTO.getId());

        int i = preparedStatement.executeUpdate();

        return i>0;

    }
    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeUpdate()>0;
    }
    @Override
    public boolean exite(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();


    }
    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if ( rs.next()) {
            String id = rs.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

    }
    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
                        pstm.setString(1, newValue + "");
                        ResultSet rst = pstm.executeQuery();
                        rst.next();
                        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
                        return customerDTO;
    }

}


