# Summary

REST-API for simple online quiz game.

## Data Model

three tables:

```
Category -|--<- Question -|--<- Answer
```


# Lessons learned

1. datamodel package must be inside app package (otherwise od error: annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}!

2. xRepository functions are auto generated (just create the base as seen in UserRepository, and adapt the return type )

3. avoid simple id-attributes, name them like  the table, e.g. idQuestion, idCategory etc. (otherwise we get stupid recursions)

