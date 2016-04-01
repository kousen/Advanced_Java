package database

import database.jdbc.Person
import groovy.sql.Sql

Sql db = Sql.newInstance(
        url: 'jdbc:mysql://localhost:3306/hr', driver: 'com.mysql.jdbc.Driver',
        user: 'jpa', password: 'java')

db.execute "DROP TABLE IF EXISTS PEOPLE"
db.execute '''
    CREATE TABLE PEOPLE(
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(200) NOT NULL,
        PRIMARY KEY(id)
    )
'''

def people = [new Person(name: 'Picard'), new Person(name: 'Riker'),
              new Person(name: 'Troi'), new Person(name: 'Laforge'),
              new Person(name: 'Data'), new Person(name: 'Crusher')]

people.each { p ->
    println p
    db.executeInsert """
      insert into people(name) values(${p.name})
    """
}

println db.rows("select id, name from hr.PEOPLE").collect { row ->
    new Person(id: row.id, name: row.name)
}

db.close()
