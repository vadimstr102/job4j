package ru.job4j.lsp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;


public class ControlQualityTest {
    GregorianCalendar currentDate;
    GregorianCalendar monthAgo;
    GregorianCalendar monthLater;
    Bread bread;
    Meat meat;
    Milk milk;
    Map<String, Storage> map;

    @Before
    public void init() {
        currentDate = new GregorianCalendar();

        monthAgo = new GregorianCalendar();
        monthAgo.add(Calendar.MONTH, -1);

        monthLater = new GregorianCalendar();
        monthLater.add(Calendar.MONTH, 1);

        map = new HashMap<>();
        map.put("Shop", new Shop(new ArrayList<>()));
        map.put("Warehouse", new Warehouse(new ArrayList<>()));
        map.put("Trash", new Trash(new ArrayList<>()));
    }

    @Test
    public void whenLoadInShop() {
        bread = new Bread("Bread", monthAgo, monthLater, 100);
        meat = new Meat("Meat", monthAgo, monthLater, 200);
        milk = new Milk("Milk", monthAgo, monthLater, 300);
        ControlQuality controlQuality = new ControlQuality(map);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(map.get("Shop").getList().size(), is(3));
        Assert.assertThat(map.get("Warehouse").getList().size(), is(0));
        Assert.assertThat(map.get("Trash").getList().size(), is(0));
    }

    @Test
    public void whenLoadInWarehouse() {
        bread = new Bread("Bread", currentDate, monthLater, 100);
        meat = new Meat("Meat", currentDate, monthLater, 200);
        milk = new Milk("Milk", currentDate, monthLater, 300);
        ControlQuality controlQuality = new ControlQuality(map);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(map.get("Shop").getList().size(), is(0));
        Assert.assertThat(map.get("Warehouse").getList().size(), is(3));
        Assert.assertThat(map.get("Trash").getList().size(), is(0));
    }

    @Test
    public void whenLoadInTrash() {
        bread = new Bread("Bread", monthAgo, currentDate, 100);
        meat = new Meat("Meat", monthAgo, currentDate, 200);
        milk = new Milk("Milk", monthAgo, currentDate, 300);
        ControlQuality controlQuality = new ControlQuality(map);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(map.get("Shop").getList().size(), is(0));
        Assert.assertThat(map.get("Warehouse").getList().size(), is(0));
        Assert.assertThat(map.get("Trash").getList().size(), is(3));
    }
}
