package cn.errison.feature.demo.annotation.common;

import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationDefinition {

    public AnnotationDefinition(){

    }

    @PostConstruct
    public void afterConstruct(){
        System.out.println("PostConstruct method");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("PreDestroy method");
    }

    public void developerCode(){
        System.out.println("developer code");
    }

    @Generated(
        value = "ClassNameThatGeneratedThisCode",
        comments = "This is Tool Generated Code",
        date = "5 June 2007"
    )
    public void toolGeneratedCode(){
        System.out.println("tool code");
    }

    public static void main(String[] args) {
        AnnotationDefinition definition = new AnnotationDefinition();
        definition.developerCode();
        definition.toolGeneratedCode();
    }

}