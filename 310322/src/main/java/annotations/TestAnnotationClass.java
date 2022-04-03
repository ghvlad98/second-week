package annotations;

import utils.LOG;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@TestAnnotation
@SingleTestAnnotation(
        item = "Ciao"
)
public class TestAnnotationClass {
    @SingleTestAnnotation(
            item = "Ciao"
    )
    private String annotation;

    public static boolean isAnnotationPresents() {
        Class test = TestAnnotationClass.class;
        if (test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is annotation!");
        else LOG.getInstance().debug("There is not annotation!");
        return false;
    }

    public static void main(String[] args) {
        Class test = TestAnnotationClass.class;
        if (test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is annotation!");
        else LOG.getInstance().debug("There is not annotation!");

        Class c = TestAnnotationClass.class;
        Annotation[] a = c.getAnnotations();
        LOG.getInstance().debug("return");
    }
}
