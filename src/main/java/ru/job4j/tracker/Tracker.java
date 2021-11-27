package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        //* Находим index по id */
        int index = indexOf(id);
        //* При нахождении index возвращаем Item, если нет - null */
        return index != -1 ? items[index] : null;
       // Item rsl = null;
        //for (int index = 0; index < size; index++) {
          //  Item item = items[index];
            //if (item.getId() == id) {
              //  rsl = item;
                //break;
            //}
        //}
        //return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        //Item inItem = new Item();
        //inItem = findById(id);
        if (findById(id) == null) return rsl;
        findById(id).setName(item.getName());
        rsl = true;
        return rsl;
        //inItem = item;

    }

}