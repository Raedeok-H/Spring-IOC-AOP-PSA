package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메소드에 적용하겠다는 의미
@Retention(RetentionPolicy.RUNTIME) //언제까지 유지할것인가 -> 런타임까지
public @interface LogExecutionTime {

}
