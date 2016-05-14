package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lesson10Enum.TrafficLamp;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ItcastAnnotation {
	public String color() default  "blue";
	public String value();
	public int[] arrAtt();
	public TrafficLamp lamp() default TrafficLamp.Red;
	public MetaAnnotation annotationAttr() default @MetaAnnotation("abs");
}
