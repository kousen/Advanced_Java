import groovy.sql.Sql
import spock.lang.Specification

class DBSpec extends Specification {

    void 'verify database exists'() {
        given:
        Sql db = Sql.newInstance(
                url: 'jdbc:mysql://localhost:3306/hr', driver: 'com.mysql.jdbc.Driver',
                user: 'jpa', password: 'java')

        expect:
        db.rows('select * from people').size() == 6
    }
}
