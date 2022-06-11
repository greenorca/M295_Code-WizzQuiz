# Summary

REST-API for simple online quiz game.

## Data Model

three tables:

```
Category -|--<- Question -|--<- Answer
```

## Database Setup (required)

as show in *application.properties*:

```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
```

## REST-API documentation

see http://localhost:8080/v3/api-docs/ 

Imlementation according to https://www.baeldung.com/spring-rest-openapi-documentation (just added the springdoc-openapi-ui dependency in pom.xml) 

## Demo Data

```sql
DELETE FROM answer;
DELETE FROM question;
DELETE FROM category;

INSERT INTO category VALUES 
(1, "database"),
(2, "java"),
(3, "mathe");

INSERT INTO question VALUES
(1, "Welcher Befehl dient zur Abfrage von Daten",1),
(2, "Welcher Befehl dient zur Einfügen von Daten",1),
(3, "Welcher Befehl dient zur Erstellen von Tabellen",1);

INSERT INTO answer (answer_text, correct, question_id_question) VALUES
("SELECT", true, 1),
("SHOW", false, 1),
("ECHO", false, 1),
("INSERT", true, 2),
("ADD", false, 2),
("PUSH", false, 2),
("CREATE", true, 3),
("ADD", false, 3),
("WRITE", false, 3);

INSERT INTO question VALUES
(11, "Welcher Datentyp taugt für physikalische Messwerte",2),
(12, "Welcher Datentyp kann genau ein Zeichen speichern",2),
(13, "Welcher Befehl dient zur Ausgabe der Zeichenkette Hello World",2);
```

# Lessons learned

1. datamodel package must be inside app package (otherwise odd error: annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}!

2. xRepository functions are auto generated (just create the base as seen in UserRepository, and adapt the return type )

4. prevent recursive reads between one2many and many2one - references:

	- in the N-part:
	```
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Category category;
	```
	
	- in the 1-part:
	```
	@OneToMany(mappedBy="category")
	@JsonManagedReference
	private Set<Question> questions; 
	```

5. or **prevent recursive reads by disabling the back reference completely**:

	```
	/*@OneToMany(mappedBy = "question")
	@JsonManagedReference
	private Set<Answer> answers;
	
	public Set<Answer> getAnswers() {
		return answers;
	}*/
	```