package seok.repository;

import seok.model.User;

import java.util.List;

public interface UserRepository {
    public List<User> selectAll() throws Exception;

    public User select(String id) throws Exception;

    public int insert(User user) throws Exception;

    public int update(User user) throws Exception;

    public int delete(String id) throws Exception;
}
