package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();

    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }

    public Model() {
        model = new HashMap<>();
        model.put(1, new User("Ivan", "Tahirev", 50000));
        model.put(2, new User("Anton", "Osipov", 512300));
        model.put(3, new User("Vasy", "Pupkin", 1000));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return model;
    }

    public void update(int userId, User newUser) {
        if (model.containsKey(userId)) {
            model.put(userId, newUser);
        }
    }

    public void delete(int userId) {
        if (model.containsKey(userId)) {
            model.remove(userId);
        }
    }
}
