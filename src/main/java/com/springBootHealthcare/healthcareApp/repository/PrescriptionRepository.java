package com.springBootHealthcare.healthcareApp.repository;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Prescription;
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
public class PrescriptionRepository {


    public static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean createPrescription(Prescription prescription) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO prescription(prescriptionId,prescriptionDetails,personId)VALUES(?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,prescription.getPrescriptionId());
            preparedStatement.setString(2, prescription.getPrescriptionDetails());
            preparedStatement.setInt(3, prescription.getPersonId());

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

    public List<Prescription> retrieveAllPrescription() throws SQLException {

        this.initConnection();

        List<Prescription> prescriptionList = new ArrayList<>();

        String query = "SELECT * FROM prescription";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Prescription prescription = new Prescription(
                        resultSet.getInt("prescriptionId"),
                        resultSet.getString("prescriptionDetails"),
                        resultSet.getInt("personId")
                );

                prescriptionList.add(prescription);
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return prescriptionList;
    }

    public List<Prescription> retrieveById(int prescriptionId) throws SQLException {

        this.initConnection();

        List<Prescription> prescriptionList = new ArrayList<>();

        String query = "SELECT * FROM prescription WHERE prescriptionId=?";

        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.setInt(1,prescriptionId);
            if(resultSet.next()){
                Prescription prescription = new Prescription(
                        resultSet.getInt("prescriptionId"),
                        resultSet.getString("prescriptionDetails"),
                        resultSet.getInt("personId")
                );

                return List.of(prescription);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return prescriptionList;
    }

    public Prescription updatePrescription(int prescriptionId,Prescription prescription) throws SQLException {

        this.initConnection();

        String query = "UPDATE prescription SET prescriptionDetails=? WHERE prescriptionId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(prescription));
            preparedStatement.setInt(2, prescriptionId);

            int rowUpdated = preparedStatement.executeUpdate();

            return prescription;

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

    public boolean deletePrescription(int prescriptionId){

        String query = "DELETE FROM prescription WHERE prescriptionId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, prescriptionId);

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
