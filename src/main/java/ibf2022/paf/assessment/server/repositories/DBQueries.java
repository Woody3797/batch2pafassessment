package ibf2022.paf.assessment.server.repositories;

public class DBQueries {

        public final static String FIND_USER_BY_USERNAME = """
                SELECT * FROM user WHERE username = ?
                """;

        public final static String INSERT_USER = """
                INSERT INTO user(user_id,username,name) VALUES(?, ?, ?)
                """;

        public final static String INSERT_TASKS = """
                INSERT INTO task(user_id, description, priority, due_date) VALUES(?, ?, ?, ?)    
                """;
}
