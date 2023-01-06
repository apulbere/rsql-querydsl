# RSQL QueryDSL

RSQL-QueryDSL is a lightweight library that helps to build restful APIs using SQL like operators with QueryDSL.

[Pet Shop Example](https://github.com/apulbere/pet-shop-rsql-querydsl):

```
http://localhost:8080/pets?id.in=1,3&born.btw=2000-10-01,2020-01-01&nikname.like=Br
```

### How to use
#### Add dependency to your POM
```xml
<dependency>
    <groupId>io.github.apulbere</groupId>
    <artifactId>rsql-querydsl</artifactId>
    <version>1.0</version>
</dependency>
```

#### Define a DTO that will represent your search criteria
```java
@Setter
@Getter
public class PetCriteria {
    LongCriteria id = LongCriteria.empty();
    LocalDateCriteria born = LocalDateCriteria.empty();
    StringCriteria petType = StringCriteria.empty();
    StringCriteria nickname = StringCriteria.empty();
}
```

#### Use your model in controller
```java
@GetMapping("/pets")
List<PetRecord> search(PetCriteria criteria, Pageable page) {
    var predicate = criteria.id.match(pet.id)
            .and(criteria.born.match(pet.birthdate))
            .and(criteria.nickname.match(pet.name))
            .and(criteria.petType.match(pet.type));
    return petRepository.findAll(predicate, page)
            .stream()
            .map(petMapper::map)
            .toList();
}
```

### License
The Apache License, Version 2.0
