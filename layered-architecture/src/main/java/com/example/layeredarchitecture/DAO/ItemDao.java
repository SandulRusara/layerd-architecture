package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
     boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
     boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
     boolean exitsItem(String code) throws SQLException, ClassNotFoundException ;
     String genarateNewId() throws SQLException, ClassNotFoundException;
}
