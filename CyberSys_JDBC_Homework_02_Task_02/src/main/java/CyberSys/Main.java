package CyberSys;

import CyberSys.dao.DAOFactory;
import CyberSys.dao.ICarDAO;
import CyberSys.dao.IDAOFactory;
import CyberSys.entity.Car;

import java.util.List;

// !!! Перед запуском програми необхідно виконати скрипти з папки WorkBench_Scripts !!!
public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        ICarDAO carDAO = factory.getCarDAO();

        /*
        Car car = new Car();
        car.setModel("100");
        car.setModelYear(2000);
        carDAO.insert(car);

        car = new Car();
        car.setModel("200");
        car.setModelYear(2005);
        carDAO.insert(car);

        car = new Car();
        car.setModel("300");
        car.setModelYear(2011);
        carDAO.insert(car);
        */
        
        System.out.println();

        int maxId = 1;
        List<Car> cars = carDAO.findAll();
        for (Car current : cars) {
            System.out.println(current);
            maxId = current.getId();
        }

        System.out.println();
        System.out.println("Car with id = " + maxId + " has been found:");
        Car carWithMaxId = carDAO.findById(maxId);
        System.out.println(carWithMaxId);

        System.out.println();
        carWithMaxId.setModelYear(2012);
        boolean result = carDAO.update(carWithMaxId);
        if (result) {
            System.out.println("Car with id = " + maxId + " has been updated:");
            System.out.println(carWithMaxId);
        } else {
            System.out.println("Car with id = " + maxId + " has`t been updated:");
            System.out.println(carWithMaxId);
        }

        System.out.println();
        result = carDAO.deleteById(maxId);
        if (result) {
            System.out.println("Car with id = " + maxId + " has been deleted");

        } else {
            System.out.println("Car with id = " + maxId + " has`t been deleted:");
        }

        System.out.println();
        cars = carDAO.findAll();
        for (Car current : cars) {
            System.out.println(current);
        }
    }
}