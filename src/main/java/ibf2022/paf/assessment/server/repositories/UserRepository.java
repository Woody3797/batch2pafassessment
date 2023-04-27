package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> findUserByUsername(String username) {
        try {
            User user = jdbcTemplate.queryForObject(DBQueries.FIND_USER_BY_USERNAME, BeanPropertyRowMapper.newInstance(User.class), username);
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public String insertUser(User user) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 8);
        user.setUserId(id);
        String name = user.getName();
        String username = user.getUsername();
        try {
            int rows = jdbcTemplate.update(DBQueries.INSERT_USER, id, username, name);
            return rows > 0 ? id : "unable to insert";
        } catch (Exception e) {
            return "error: unable to insert";
        }
    }
}
