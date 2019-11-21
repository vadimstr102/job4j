package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteElement() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Assert.assertEquals(tracker.findById(item2.getId()), null);
    }

    @Test
    public void whenFindAllElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> arrayWithoutNull = tracker.findAll();
        assertThat(arrayWithoutNull.size(), is(3));
    }

    @Test
    public void whenFindByNameElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test2");
        Item item4 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> arrayOneName = tracker.findByName("test1");
        assertThat(arrayOneName.size(), is(2));
    }

    @Test
    public void whenFindByIdElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Assert.assertEquals(tracker.findById(item3.getId()).getName(), item3.getName());
    }
}
