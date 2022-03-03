# RockMapper

RockMapper is a Java library which is functionality for reading and writing POJO,

## Usage


```java
public class Entity {
    private String name;
    private String lastName;
    private int age;
    private boolean clip;

    public Entity(String name,String lastName,int age,boolean clip){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.clip = clip;

    }
}
```

```java
public class ExampleDTO {
    private String name;
    private String lastName;
    private int age;
}
```

```java
public class Main {
    public static void main(String[] args) throws DefaultConstructorNotFoundException, IllegalAccessException {

        Entity entity = new Entity("Jack","Whitson",19,true);

        RockMapper<ExampleDTO> rockMapper = new BasicMapper<>(entity,ExampleDTO.class);

        ExampleDTO exampleDTO = rockMapper.map();

        System.out.println(exampleDTO.toString());

    }
}

```

```java
#Output
ExampleDTO{name='Jack', lastName='Whitson', age=19}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
