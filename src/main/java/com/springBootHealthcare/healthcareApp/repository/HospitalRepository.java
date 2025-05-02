package com.springBootHealthcare.healthcareApp.repository;

import com.springBootHealthcare.healthcareApp.model.Hospital;
import com.springBootHealthcare.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class HospitalRepository {
    public static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean createHospital(Hospital hospital) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO hospital(hospitalId,hospitalName,address,emailId,contactNo)VALUES(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,hospital.getHospitalId());
            preparedStatement.setString(2, hospital.getHospitalName());
            preparedStatement.setString(3, hospital.getAddress());
            preparedStatement.setString(4, hospital.getEmailId());
            preparedStatement.setString(5, hospital.getContactNo());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Hospital> retrieveAllHospital() throws SQLException {

        this.initConnection();

        List<Hospital> hospitalList = new ArrayList<>();

        String query = "SELECT * FROM hospital";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Hospital hospital = new Hospital(
                        resultSet.getInt("hospitalId"),
                        resultSet.getString("hospitalName"),
                        resultSet.getString("address"),
                        resultSet.getString("emailId"),
                        resultSet.getString("contactNo")
                );

                hospitalList.add(hospital);
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return hospitalList;
    }

    public List<Hospital> retrieveById(int hospitalId) throws SQLException {

        this.initConnection();

        List<Hospital> hospitalList = new ArrayList<>();

        String query = "SELECT * FROM hospital WHERE hospitalId=?";

        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.setInt(1,hospitalId);
            if(resultSet.next()){
                Hospital hospital = new Hospital(
                        resultSet.getInt("hospitalId"),
                        resultSet.getString("hospitalName"),
                        resultSet.getString("address"),
                        resultSet.getString("emailId"),
                        resultSet.getString("contactNo")
                );

                return List.of(hospital);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return hospitalList;
    }

    public boolean updateHospital(int hospitalId,String hospitalName) throws SQLException {

        this.initConnection();

        String query = "UPDATE hospital SET hospitalName=? WHERE hospitalId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, hospitalName);
            preparedStatement.setInt(2, hospitalId);

            int rowUpdated = preparedStatement.executeUpdate();

            return rowUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
    }

    public boolean deleteHospital(int hospitalId){

        String query = "DELETE FROM hospital WHERE hospitalId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hospitalId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
