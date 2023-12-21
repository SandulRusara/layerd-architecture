package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sqlUtil {
    public static <T> T text(String sql, Object...ob) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i=0;i<ob.length;i++){
            preparedStatement.setObject(i+1,ob[i]);
        }
        if(sql.startsWith("select")){
           return (T)preparedStatement.executeQuery();
        }else {
            return(T)(Boolean)(preparedStatement.executeUpdate()>0);
        }

    }
}
