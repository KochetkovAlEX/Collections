package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carList;


    @BeforeEach
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i<100;i++){
            carList.add(new Car("audi" + i, i));
        }
    }

    @Test
    public void whenAdd100ElementsThenSizeMustBe100(){
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThanSizeMustBeDecrease(){
        assertTrue(carList.removeAt(3));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThanSizeMustBeDecrease(){
        Car car = new Car("Honda", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNotExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Honda", 15);
        assertFalse(carList.remove(car));
    }

    @Test
    public void whenListClearedThanSizeMustBeZero(){
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100)); //проверка исключения
    }

    @Test
    public void insertIntoMiddle(){
        Car car = new Car("BMW", 1);
        carList.add(car, 50);

        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }



    @Test
    public void methodGetReturnedRightValue(){
        Car car = new Car("0", 0);
        assertEquals("0", car.getBrand());
    }
}