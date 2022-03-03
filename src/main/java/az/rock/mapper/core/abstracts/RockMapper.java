package az.rock.mapper.core.abstracts;

import az.rock.mapper.exception.DefaultConstructorNotFoundException;

public interface RockMapper<D> {
    // D - DTO , T object Type
    D map() throws DefaultConstructorNotFoundException, IllegalAccessException;

}
