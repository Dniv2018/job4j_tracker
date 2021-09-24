package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return items;
    }

    public Item[] findByName(String key) {
        String[] rsl = new String[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            //Item item = items[index];
            String name = items[index].getName();
            if (key.equals(name)) {
                rsl[size] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        Item[] itemResult = new Item[rsl.length];
        for (int index = 0; index < rsl.length; index++) {
            itemResult[index].setName(rsl[index]);
        }
        return itemResult;
    }

}