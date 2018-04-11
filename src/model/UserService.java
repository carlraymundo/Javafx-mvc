package model;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {
    private List<User> users = new ArrayList<User>();

    @Override
    public List<User> get() {
        return users;
    }

    @Override
    public User get(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(User entity) {
        return users.add(entity);
    }

    @Override
    public boolean delete(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.remove(i) != null;
            }
        }
        return false;
    }

    @Override
    public boolean edit(long id, User entity) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                User u = users.get(i);

                u.setUsername(entity.getUsername());
                u.setPassword(entity.getPassword());
                return true;
            }
        }
        return false;
    }

    public void displayUsers()
    {
        for(User u: users)
            System.out.println("Hello " + u.getUsername());
    }
}
