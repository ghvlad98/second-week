package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
    ElementType.TYPE,
    ElementType.FIELD
})
public @interface SingleTestAnnotation {
    String item();
}
