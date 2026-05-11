package CyberSys.dao;

import java.sql.SQLException;

public class DAOFactory implements IDAOFactory{

private static IDAOFactory factory;

    private static void createDbAndTables() {

    }

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver has been load");
            // Створимо БД і таблиці
            createDbAndTables();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found");;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static synchronized IDAOFactory getInstance() {
        if(factory == null){
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public ICarDAO getCarDAO() {
        return new CarJDBCDao();
    }
}
