package seok.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import seok.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String MAPPER_NAME_SPACE = "user.";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<User> selectAll() throws Exception {
        return sqlSession.selectList(MAPPER_NAME_SPACE + "selectAll");
    }

    @Override
    public User select(String id) throws Exception {
        return sqlSession.selectOne(MAPPER_NAME_SPACE + "select", id);
    }

    @Override
    public int insert(User user) throws Exception {
        return sqlSession.insert(MAPPER_NAME_SPACE + "insertUser", user);
    }

    @Override
    public int update(User user) throws Exception {
        return sqlSession.update(MAPPER_NAME_SPACE + "update", user);
    }

    @Override
    public int delete(String id) throws Exception {
        return sqlSession.delete(MAPPER_NAME_SPACE + "delete", id);
    }
}
