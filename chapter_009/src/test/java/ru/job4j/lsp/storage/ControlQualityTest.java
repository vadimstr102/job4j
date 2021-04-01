package ru.job4j.lsp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;

public class ControlQualityTest {
    GregorianCalendar currentDate;
    GregorianCalendar oneMonthAgo;
    GregorianCalendar fourMonthsAgo;
    GregorianCalendar oneMonthLater;
    Bread bread;
    Meat meat;
    Milk milk;
    List<Store> list;

    @Before
    public void init() {
        currentDate = new GregorianCalendar();

        oneMonthAgo = new GregorianCalendar();
        oneMonthAgo.add(Calendar.MONTH, -1);

        fourMonthsAgo = new GregorianCalendar();
        fourMonthsAgo.add(Calendar.MONTH, -4);

        oneMonthLater = new GregorianCalendar();
        oneMonthLater.add(Calendar.MONTH, 1);

        list = new ArrayList<>();
        list.add(new Warehouse(new ArrayList<>()));
        list.add(new Shop(new ArrayList<>()));
        list.add(new Trash(new ArrayList<>()));
    }

    @Test
    public void whenLoadInShop() {
        bread = new Bread("Bread", oneMonthAgo, oneMonthLater, 100, 50);
        meat = new Meat("Meat", oneMonthAgo, oneMonthLater, 200, 50);
        milk = new Milk("Milk", oneMonthAgo, oneMonthLater, 300, 50);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(list.get(0).getList().size(), is(0));
        Assert.assertThat(list.get(1).getList().size(), is(3));
        Assert.assertThat(list.get(2).getList().size(), is(0));
    }

    @Test
    public void whenLoadInWarehouse() {
        bread = new Bread("Bread", currentDate, oneMonthLater, 100, 50);
        meat = new Meat("Meat", currentDate, oneMonthLater, 200, 50);
        milk = new Milk("Milk", currentDate, oneMonthLater, 300, 50);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(list.get(0).getList().size(), is(3));
        Assert.assertThat(list.get(1).getList().size(), is(0));
        Assert.assertThat(list.get(2).getList().size(), is(0));
    }

    @Test
    public void whenLoadInTrash() {
        bread = new Bread("Bread", oneMonthAgo, currentDate, 100, 50);
        meat = new Meat("Meat", oneMonthAgo, currentDate, 200, 50);
        milk = new Milk("Milk", oneMonthAgo, currentDate, 300, 50);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.loadFood(bread);
        controlQuality.loadFood(meat);
        controlQuality.loadFood(milk);
        Assert.assertThat(list.get(0).getList().size(), is(0));
        Assert.assertThat(list.get(1).getList().size(), is(0));
        Assert.assertThat(list.get(2).getList().size(), is(3));
    }

    @Test
    public void whenMakeDiscount() {
        bread = new Bread("Bread", fourMonthsAgo, oneMonthLater, 100, 20);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.loadFood(bread);
        Assert.assertThat(list.get(1).getList().get(0).getPrice(), is(80.0));
    }
}
