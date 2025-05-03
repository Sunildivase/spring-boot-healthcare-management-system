package com.springBootHealthcare.healthcareApp.repository;

import com.springBootHealthcare.healthcareApp.model.Appointment;
import com.springBootHealthcare.healthcareApp.model.Department;
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
public class AppointmentRepository {

    public static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean createAppointment(Appointment appointment) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO appointment(appointmentId,personId,doctorId,hospitalId,deptId)VALUES(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,appointment.getAppointmentId());
            preparedStatement.setInt(2, appointment.getPersonId());
            preparedStatement.setInt(3, appointment.getDoctorId());
            preparedStatement.setInt(4, appointment.getHospitalId());
            preparedStatement.setInt(5, appointment.getDeptId());


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

    public List<Appointment> retrieveAllAppointment() throws SQLException {

        this.initConnection();

        List<Appointment> appointmentList = new ArrayList<>();

        String query = "SELECT * FROM appointment";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("personId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getInt("hospitalId"),
                        resultSet.getInt("deptId")

                );

                appointmentList.add(appointment);
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return appointmentList;
    }

    public List<Appointment> retrieveById(int appointmentId) throws SQLException {

        this.initConnection();

        List<Appointment> appointmentList = new ArrayList<>();

        String query = "SELECT * FROM appointment WHERE appointmentId=?";

        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.setInt(1,appointmentId);
            if(resultSet.next()){
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("personId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getInt("hospitalId"),
                        resultSet.getInt("deptId")

                );

                return List.of(appointment);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return appointmentList;
    }

    public Appointment updateAppointment(int appointmentId,Appointment appointment) throws SQLException {

        this.initConnection();

        String query = "UPDATE appointment SET appointmentId=? WHERE appointmentId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(appointment));
            preparedStatement.setInt(2, appointmentId);

            int rowUpdated = preparedStatement.executeUpdate();

            return appointment;

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

    public boolean deleteAppointment(int appointmentId){

        String query = "DELETE FROM appointment WHERE appointmentId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, appointmentId);

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
