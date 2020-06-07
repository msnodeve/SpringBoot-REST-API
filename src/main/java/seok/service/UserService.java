package seok.service;

import seok.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUsers() throws Exception;

    public User findByUserId(String id) throws Exception;

    public int registry(User user) throws Exception;

    public int modify(User user) throws Exception;

    public int remove(String id) throws Exception;
}
