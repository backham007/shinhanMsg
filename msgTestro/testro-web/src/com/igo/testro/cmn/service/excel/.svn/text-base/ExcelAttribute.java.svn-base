package com.igo.testro.cmn.service.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.poi.ss.usermodel.CellStyle;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAttribute {

	public static final int STRING = 1;
	public static final int INT = 2;
	public static final int BOOLEAN = 3;
	
	public static final short ALIGN_LEFT = CellStyle.ALIGN_LEFT;
	public static final short ALIGN_RIGHT = CellStyle.ALIGN_RIGHT;
	public static final short ALIGN_CENTER = CellStyle.ALIGN_CENTER;
	
	int type() default STRING;

	short align() default ALIGN_LEFT;

	String headerNm() default "";
	
	boolean isMark() default false;

	boolean required() default false;

}
