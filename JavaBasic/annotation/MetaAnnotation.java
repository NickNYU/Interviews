package annotation;

import java.lang.annotation.Annotation;

public @interface MetaAnnotation {
	String value();
}

class test implements MetaAnnotation {

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}
	
}