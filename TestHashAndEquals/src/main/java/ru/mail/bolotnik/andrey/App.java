package ru.mail.bolotnik.andrey;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int id1 = 1;
        int id2 = 2;
        int id3 = 1;
        int id4 = 2;
        String name = "Ivan";
        String surname = "Ivanov";


        Set <EntityWithDefaultParam> def = new HashSet<>();
        Set <EntityWithCustomParam> custom = new HashSet<>();


        EntityWithDefaultParam def1 = new EntityWithDefaultParam(id1, name, surname);
        EntityWithDefaultParam def2 = new EntityWithDefaultParam(id2, name, surname);
        EntityWithDefaultParam def3 = new EntityWithDefaultParam(id3, name, surname);
        EntityWithDefaultParam def4 = new EntityWithDefaultParam(id4, name, surname);

        EntityWithCustomParam cast1= new EntityWithCustomParam(id1, name, surname);
        EntityWithCustomParam cast2= new EntityWithCustomParam(id2, name, surname);
        EntityWithCustomParam cast3= new EntityWithCustomParam(id3, name, surname);
        EntityWithCustomParam cast4= new EntityWithCustomParam(id4, name, surname);

        def.add(def1);
        def.add(def2);
        def.add(def3);
        def.add(def4);


        custom.add(cast1);
        custom.add(cast2);
        custom.add(cast3);
        custom.add(cast4);


        System.out.println(def);
        System.out.println(custom);












    }
}
