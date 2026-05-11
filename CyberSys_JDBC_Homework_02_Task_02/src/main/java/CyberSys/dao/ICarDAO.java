package CyberSys.dao;

import CyberSys.entity.Car;

import java.util.List;

public interface ICarDAO {
    void  insert(Car car);

    Car findById(int id);

    boolean update(Car car);

    boolean deleteById(int id);

    List<Car> findAll();
}
