package lesson49Proxy;

import java.lang.reflect.*;
import java.util.Collection;

public class ProxyTest {
	
	public static void main(String[] args) {
		Class classProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(classProxy.getName());
		
		Constructor[] constructs = classProxy.getConstructors();
		for(Constructor construct : constructs) {
			String name = construct.getName();
			//System.out.println(name);
			StringBuffer sb = new StringBuffer (name);
			sb.append('(');
			Parameter[] parameters = construct.getParameters();
			for(Parameter parameter : parameters) {
				sb.append(parameter.getType().toGenericString()).append(",");
			}
			sb.append(')');
			System.out.println(sb.toString());
		}
	}
}
