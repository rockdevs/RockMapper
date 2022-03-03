package az.rock.mapper.core.concretes;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class RockReflection {

    public  final Reflections REFLECTIONS = new Reflections(
            new ConfigurationBuilder()
                    .setScanners(
                            Scanners.FieldsAnnotated,
                            Scanners.TypesAnnotated)
                    .setParallel(true)
    );

    private static RockReflection rockReflection = null;

    public static RockReflection init(){
        if (rockReflection==null){
            synchronized (RockReflection.class){
                if(rockReflection==null){
                    rockReflection = new RockReflection();
                    return rockReflection;
                }
            }
        }
        return rockReflection;
    }

    private RockReflection(){}



}
