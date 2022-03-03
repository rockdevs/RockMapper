package az.rock.mapper.core.concretes;

import az.rock.mapper.core.abstracts.RockMapper;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;

public class BasicMapper<D,T> implements RockMapper<D,T> {

    private final Reflections reflections = new Reflections(ClasspathHelper.forJavaClassPath(),Scanners.FieldsAnnotated,Scanners.TypesAnnotated);

    private D dataTransferObject;

    private T entityObject;


    @Override
    public D map() {
        return null;
    }




}
