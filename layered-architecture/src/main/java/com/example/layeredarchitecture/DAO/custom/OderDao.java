package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.crudDao;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OderDao extends crudDao<OrderDTO> {/*
    public String genarateNewOderId() throws SQLException, ClassNotFoundException;*/
    public boolean checkOderId(String orderId) throws SQLException, ClassNotFoundException;
    public String genarateNewOderId() throws SQLException, ClassNotFoundException;
}
