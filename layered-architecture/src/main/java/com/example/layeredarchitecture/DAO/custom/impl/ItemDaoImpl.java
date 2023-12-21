package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.custom.ItemDao;
import com.example.layeredarchitecture.DAO.sqlUtil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;



public class ItemDaoImpl implements ItemDao {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet text  = sqlUtil.text("select  * from item");
        ArrayList<ItemDTO> arrayList = new ArrayList();
       while (text.next()){
           ItemDTO itemDTO = new ItemDTO(text.getString(1),text.getString(2),text.getBigDecimal(3),text.getInt(4));
           arrayList.add(itemDTO);
       }
       return arrayList;
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
       /*ResultSet rst= sqlUtil.text("select  * from item");
        ArrayList<ItemDTO> getAllItems = new ArrayList<>();
        System.out.println(rst);
        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
            getAllItems.add(itemDTO);
        }
        return getAllItems();*/
    }
    @Override
    public boolean Delete(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        int i = pstm.executeUpdate();
//        return i>0;
       return sqlUtil.text("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean Save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1,itemDTO.getCode());
//        pstm.setString(2,itemDTO.getDescription());
//        pstm.setBigDecimal(3,itemDTO.getUnitPrice());
//        pstm.setInt(4,itemDTO.getQtyOnHand());
//        int i = pstm.executeUpdate();
//        return i>0;
        return sqlUtil.text("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public boolean Update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setString(1,itemDTO.getDescription());
//        pstm.setBigDecimal(2,itemDTO.getUnitPrice());
//        pstm.setInt(3,itemDTO.getQtyOnHand());
//        pstm.setString(4,itemDTO.getCode());
//        int i = pstm.executeUpdate();
//        return i>0;
      ResultSet resultSet= sqlUtil.text("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
      return resultSet.next();

    }
    @Override
    public boolean exite(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();
       ResultSet resultSet= sqlUtil.text("select code FROM Item WHERE code=?",code);
       return resultSet.next();
    }
    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
       ResultSet rst= sqlUtil.text("select code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO finfItem(String newItemCode) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//                    PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//                    pstm.setString(1, newItemCode + "");
//                    ResultSet rst = pstm.executeQuery();
        ResultSet rst= sqlUtil.text("select * FROM Item WHERE code=?",newItemCode);
                    rst.next();
                    ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
                    return item;
    }

}
