package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        MemTracker memTracker = new MemTracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        memTracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        memTracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(memTracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteElement() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.delete(item2.getId());
        Assert.assertNull(memTracker.findById(item2.getId()));
    }

    @Test
    public void whenFindAllElements() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        List<Item> arrayWithoutNull = memTracker.findAll();
        assertThat(arrayWithoutNull.size(), is(3));
    }

    @Test
    public void whenFindByNameElements() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test1");
        Item item3 = new Item("test2");
        Item item4 = new Item("test3");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.add(item4);
        List<Item> arrayOneName = memTracker.findByName("test1");
        assertThat(arrayOneName.size(), is(2));
    }

    @Test
    public void whenFindByIdElements() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.add(item4);
        Assert.assertEquals(memTracker.findById(item3.getId()).getName(), item3.getName());
    }
}
