package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int index = getIndex(id);
        if (index != -1) {
            result = simpleArray.get(index);
        }
        return result;
    }

    public int getIndex(String id) {
        int result = -1;
        int index = 0;
        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}
