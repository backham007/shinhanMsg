package com.igo.testro.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>
 * 프로그램명:LogInfo.java<br/>
 * 설명 : 컨트롤 메소드에 대한 설명 어노테이션<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2012. 3. 5. : kangwoo : 최초작성
 * </ul> 
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfo {
	String description() default "설명없음";
}
