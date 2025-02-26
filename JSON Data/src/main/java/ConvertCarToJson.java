import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

class Car {
    private String make;
    private String model;
    private int year;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

public class ConvertCarToJson {
    public static void main(String[] args) throws IOException {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear(2020);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.println(json);
    }
}
