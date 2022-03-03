package az.rock.mapper.core.concretes;

import az.rock.mapper.DefaultConstructorNotFoundException;
import az.rock.mapper.core.abstracts.RockMapper;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class BasicMapper<D,E> implements RockMapper<D> {


    private final Class<D> dClass;

    private final E entityObject;

    private  D dtoInstance;


    Reflections reflections = RockReflection.init().REFLECTIONS;

    public BasicMapper(E entityObject,Class<D> dClass){
       this.entityObject = entityObject;
       this.dClass = dClass;
    }

    @Override
    public D map() {
        return null;
    }

    private Optional<D> newInstance() throws DefaultConstructorNotFoundException {
        try {
            return Optional.of(this.dClass.getConstructor().newInstance());
        }catch (NoSuchMethodException e){
            throw new DefaultConstructorNotFoundException();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    private Field[] getEntityField(){
        return this.entityObject.getClass().getFields();
    }


    private Field[] getDTOFields() throws DefaultConstructorNotFoundException {
        Optional<D> optionalDTOInstance = this.newInstance();
        optionalDTOInstance.ifPresent(d -> this.dtoInstance = d);
        return this.dtoInstance.getClass().getFields();
    }

}
