package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    @Test
    public void createItem() {
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.initConnectionRollback();
            tracker.add(new Item("name"));
            tracker.add(new Item("desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() {
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.initConnectionRollback();
            Item item1 = new Item("name1");
            Item item2 = new Item("name2");
            Item item3 = new Item("name3");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.replace(item1.getId(), item3), is(true));
            assertThat(tracker.findById(item1.getId()).getName(), is("name3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() {
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.initConnectionRollback();
            Item item1 = new Item("name1");
            Item item2 = new Item("name2");
            Item item3 = new Item("name3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.delete(item2.getId()), is(true));
            assertThat(tracker.findAll().size(), is(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
