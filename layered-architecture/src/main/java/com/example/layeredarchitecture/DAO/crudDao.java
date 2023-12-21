package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface crudDao<T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    boolean Save(T customerDTO) throws SQLException, ClassNotFoundException ;
    boolean Update(T customerDTO) throws SQLException, ClassNotFoundException ;
    boolean Delete(String id) throws SQLException, ClassNotFoundException ;

    boolean exite(String id) throws SQLException, ClassNotFoundException;
    String genarateNewId() throws SQLException, ClassNotFoundException ;
    public T search(String newValue) throws SQLException, ClassNotFoundException;
}
