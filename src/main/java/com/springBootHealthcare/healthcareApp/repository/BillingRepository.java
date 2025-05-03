package com.springBootHealthcare.healthcareApp.repository;

import com.springBootHealthcare.healthcareApp.model.Billing;
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
public class BillingRepository {


    public static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean createBilling(Billing billing) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO billing(billId,bill,totalBill,personId)VALUES(?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,billing.getBillId());
            preparedStatement.setDouble(2, billing.getBill());
            preparedStatement.setDouble(3, billing.getTotalBill());
            preparedStatement.setInt(4, billing.getPersonId());

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

    public List<Billing> retrieveAllBilling() throws SQLException {

        this.initConnection();

        List<Billing> billingList = new ArrayList<>();

        String query = "SELECT * FROM billing";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Billing billing = new Billing(
                        resultSet.getInt("billId"),
                        resultSet.getDouble("bill"),
                        resultSet.getDouble("totalBill"),
                        resultSet.getInt("personId")
                );

                billingList.add(billing);
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return billingList;
    }

    public List<Billing> retrieveById(int billId) throws SQLException {

        this.initConnection();

        List<Billing> billingList = new ArrayList<>();

        String query = "SELECT * FROM billing WHERE billId=?";

        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.setInt(1,billId);
            if(resultSet.next()){
                Billing billing = new Billing(
                        resultSet.getInt("billId"),
                        resultSet.getDouble("bill"),
                        resultSet.getDouble("totalBill"),
                        resultSet.getInt("personId")
                );

                return List.of(billing);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return billingList;
    }

    public Billing updateBilling(int billId,Billing billing) throws SQLException {

        this.initConnection();

        String query = "UPDATE billing SET totalBill=? WHERE billId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(billing));
            preparedStatement.setInt(2, billId);

            int rowUpdated = preparedStatement.executeUpdate();

            return billing;

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

    public boolean deleteBilling(int billId){

        String query = "DELETE FROM billing WHERE billId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, billId);

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
