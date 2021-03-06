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
The fields we want to be added to the DTO - must have the same name as the fields in the Entity class.
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
MIT License

Copyright (c) [2022] [RockMapper]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
