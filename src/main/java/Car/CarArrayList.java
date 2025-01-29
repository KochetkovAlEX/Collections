package Car;

import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);

        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }

        System.arraycopy(array, index+1, array, index, size-1 - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        /* arraycopy - метод, написанный на каком-то другом языке, работающий с памятью.\
         он двигает не элементы, а ячейки памяти
        Парамметры:
        1й - исходный массив.
        2й - исходная позиция. откуда перемещаем
        3й - массив назначения. куда складываем элементы
        4й - позиция назначения. на какую позицию кладём
        5й - длина. сколько элементом перемещаем
         */
//        for (int i = size; i > index; i--) { старый способ сдвига элементов
//            array[i] = array[i-1];
//        }
        array[index] = car;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2); // копирование и  увеличение массива
        }
    }

}
