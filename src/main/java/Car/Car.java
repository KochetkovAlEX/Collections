package Car;

import java.util.Objects;

public class Car {
    private String brand;
    private int number;

    Car(String brand, int number){
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }
    
}
