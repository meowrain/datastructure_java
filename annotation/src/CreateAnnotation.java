public @interface CreateAnnotation {
    int type() default 0;
    String level() default "info";
    String value() default "";
    String description() default "";
}
