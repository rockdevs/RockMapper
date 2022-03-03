package az.rock.mapper.core.concretes;

import az.rock.mapper.DefaultConstructorNotFoundException;
import az.rock.mapper.annotation.RockEntity;
import az.rock.mapper.core.abstracts.RockMapper;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BasicMapper<D,E> implements RockMapper<D> {


    private final Class<D> dClass;

    private final Class<E> eClass;

    private  Field[] dtoFields;

    private  Field[] entityFields;


    Reflections reflections = RockReflection.init().REFLECTIONS;

    public BasicMapper(Class<E> eClass,Class<D> dClass){
       this.eClass = eClass;
       this.dClass = dClass;
    }

    @Override
    public D map() {
        return null;
    }

    private D init() throws DefaultConstructorNotFoundException {
        try {
            return this.dClass.getConstructor().newInstance();
        }catch (NoSuchMethodException e){
            throw new DefaultConstructorNotFoundException();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }



    private void getEntityField(){

    }


    private void getDTOFields(){

    }

}
