package seok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seok.model.User;
import seok.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAllUsers() throws Exception {
        return repository.selectAll();
    }

    @Override
    public User findByUserId(String id) throws Exception {
        return repository.select(id);
    }

    @Override
    public int registry(User user) throws Exception {
        return repository.insert(user);
    }

    @Override
    public int modify(User user) throws Exception {
        return repository.update(user);
    }

    @Override
    public int remove(String id) throws Exception {
        return repository.delete(id);
    }
}
