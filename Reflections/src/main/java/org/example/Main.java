package org.example;

import org.example.reflections.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void calculateSum(int a, int b){
        System.out.println(a + b);
    }
    // 1. fields from same class

    public static void demoFieldReflections() {
        Object object = new Person("1","Van", "vic");
        Class<?> o = object.getClass();
        System.out.println(o);
        // get private,public,default,protected properties of class Person
        // excludes inherited fields

        for (Field field : o.getFields()) {
            System.out.println(field);
        }
        for (Field field : o.getDeclaredFields()) {
            System.out.println(field);
        }
        try{
            System.out.println(o.getDeclaredField("firstName"));
        }catch (NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
    }
    // 2. methods from same class
    public static void demoMethodReflections(){
        Object object = new Person("1","Van", "vic");
        Class<?> o = object.getClass();
        System.out.println("getMethods output");
        for (Method method : o.getMethods()) {
            System.out.println(method);
        }
        // get private,public,default,protected properties of class Person
        System.out.println("getDeclaredMethods output");
        for (Method method : o.getDeclaredMethods()) {
            System.out.println(method);
        }
        try{
            System.out.println(o.getDeclaredMethod("getFirstName"));
            Method m = o.getDeclaredMethod("getFirstName");
            System.out.println(o.getMethod("ghjhj"));
            Method m2 = o.getMethod("ghjhj");
            System.out.println(m2.invoke(object));
            try{
                System.out.println(m.invoke(object));
            } catch(IllegalAccessException e){
                System.out.println(e.getMessage());
            } catch (InvocationTargetException e){
                System.out.println(e.getMessage());
            }


        }catch(NoSuchMethodException e){
            System.out.println(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // 3. constructors from same class
    public static void demoConstructorsReflections() {
        Object object = new Person("1","Van", "vic");
        Class<?> o = object.getClass();
        System.out.println(o);
        // get private,public,default,protected properties of class Person
        // excludes inherited fields
        for (Constructor field : o.getDeclaredConstructors()) {
            System.out.println(field);
        }
    }
    // 4. annotations from the same class
    public static void demoAnnotationReflections() {
        Object object = new Person("1","Van", "vic");
        Class<?> o = object.getClass();
        System.out.println(o);
        // get private,public,default,protected properties of class Person
        // excludes inherited fields
        for (Annotation field : o.getDeclaredAnnotations()) {
            System.out.println(field);
        }
    }
    // 5. check if the given class has any super class
    public static void demoCheckSuperClassReflections() {
        Object object = new Person("1","Van", "vic");
        Class<?> o = object.getClass();
        System.out.println(o);
        // get private,public,default,protected properties of class Person
        // excludes inherited fields
        System.out.println(o.getSuperclass());
    }
}