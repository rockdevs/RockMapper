package az.rock.mapper.exception;

public class DefaultConstructorNotFoundException extends Exception {
    public DefaultConstructorNotFoundException(){
        super("Entity and DTO must have public ( non-parameters ) constructor method");
    }

}
