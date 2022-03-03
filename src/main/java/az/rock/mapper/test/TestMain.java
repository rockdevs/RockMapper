package az.rock.mapper.test;

import az.rock.mapper.DefaultConstructorNotFoundException;
import az.rock.mapper.core.abstracts.RockMapper;
import az.rock.mapper.core.concretes.BasicMapper;

public class TestMain {
    public static void main(String[] args) throws DefaultConstructorNotFoundException, IllegalAccessException {
        EntityTest entityTest = new EntityTest();
        entityTest.setName("Vugar");
        entityTest.setLastName("Mammadli");
        entityTest.setAge(19);
        entityTest.setAddress("Baku");

        RockMapper<DTOTest> mapper = new BasicMapper<>(entityTest,DTOTest.class);
        DTOTest dtoTest = mapper.map();

        System.out.println(dtoTest.toString());
    }
}
