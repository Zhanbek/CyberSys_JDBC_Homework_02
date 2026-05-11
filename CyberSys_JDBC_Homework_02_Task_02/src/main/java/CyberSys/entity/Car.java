package CyberSys.entity;

public class Car {
    private int id;
    private String model;
    private int modelYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "Car {" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}
