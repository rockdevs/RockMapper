package az.rock.mapper.core.concretes;

import az.rock.mapper.exception.DefaultConstructorNotFoundException;
import az.rock.mapper.core.abstracts.RockMapper;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class BasicMapper<D,E> implements RockMapper<D> {


    private  Class<D> targetClass;

    private  E entityObject;

    private  D dtoInstance;


    private final Reflections reflections = RockReflection.init().REFLECTIONS;

    public BasicMapper(E entityObject,Class<D> targetClass){
       this.entityObject = entityObject;
       this.targetClass = targetClass;
    }

    public BasicMapper(){}

    public void setDTOType(Class<D> dClass) {
        this.targetClass = dClass;
    }

    public void setEntityObject(E entityObject) {
        this.entityObject = entityObject;
    }

    @Override
    public D map() throws DefaultConstructorNotFoundException, IllegalAccessException {
        Field[] dtoFields = this.getDTOFields();
        Field[] eFields = this.getEntityField();

        for (int i = 0;i < dtoFields.length;i++){
            for (int k = 0; k < eFields.length;k++){
                synchronized (BasicMapper.class){
                        if(dtoFields[i].getName().equals(eFields[k].getName())){
                        dtoFields[i].setAccessible(true);
                        eFields[k].setAccessible(true);

                        dtoFields[i].set(this.dtoInstance,eFields[k].get(this.entityObject));

                        dtoFields[i].setAccessible(false);
                        eFields[k].setAccessible(false);
                        break;
                    }
                }
            }
        }
        return this.dtoInstance;
    }

    private Optional<D> newInstance() throws DefaultConstructorNotFoundException {
        try {
            return Optional.of(this.targetClass.getConstructor().newInstance());
        }catch (NoSuchMethodException e){
            throw new DefaultConstructorNotFoundException();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    private Field[] getEntityField(){
        return this.entityObject.getClass().getDeclaredFields();
    }


    private Field[] getDTOFields() throws DefaultConstructorNotFoundException {
        Optional<D> optionalDTOInstance = this.newInstance();
        optionalDTOInstance.ifPresent(d -> this.dtoInstance = d);
        return this.dtoInstance.getClass().getDeclaredFields();
    }

}
