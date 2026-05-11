package CyberSys.dao;


import CyberSys.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarJDBCDao implements ICarDAO {

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carDB?useSSL=false", "root",
                    "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Car car) {
        String query = "insert into cars(model,  model_year) values (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getModelYear());
            preparedStatement.execute();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Car findById(int id)  {
        Car car = new Car();
        String query = "SELECT Id, Model, Model_Year FROM Car WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                car.setId(rs.getInt("Id"));
                car.setModel(rs.getString("Model"));
                car.setModelYear(rs.getInt("Model_Year"));
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public boolean update(Car car) {
        String query = "UPDATE Car SET Model = ?, Model_Year = ? WHERE Id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getModelYear());
            preparedStatement.setInt(3, car.getId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Помилка при оновленні автомобіля: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM Car WHERE Id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Помилка при видаленні автомобіля: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String query = "select id, model, model_year from cars";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("Id"));
                car.setModel(resultSet.getString("Model"));
                car.setModelYear(resultSet.getInt("Model_Year"));
                cars.add(car);
            }
            return cars;
        } catch (Exception e) {
            System.err.println("Помилка при отриманні всіх автомобілів: " + e.getMessage());
        }

        return cars;
    }
}
