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

        List<Car> cars = carDAO.findAll();
        for (Car current : cars) {
            System.out.println(car);
        }


    }
}