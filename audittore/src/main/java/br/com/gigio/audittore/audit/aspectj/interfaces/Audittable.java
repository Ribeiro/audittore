/**
 * Copyright 2013 Marin Solutions
 */
package br.com.gigio.audittore.audit.aspectj.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which indicates that a controller needs auditing
 * 
 * @author gribeiro
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Audittable {

	String message() default "Auditing action";
	
}
