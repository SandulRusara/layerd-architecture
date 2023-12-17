package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    boolean SaveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
     boolean UpdateCustpomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    boolean exitesCustomer(String id) throws SQLException, ClassNotFoundException;
     String genarateNewId() throws SQLException, ClassNotFoundException ;

}
