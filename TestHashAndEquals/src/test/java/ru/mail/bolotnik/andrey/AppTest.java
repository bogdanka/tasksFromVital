package ru.mail.bolotnik.andrey;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class AppTest extends Assert {

    private final static int id1 = 1;
    private final static int id2 = 2;
    private final static int id3 = 1;
    private final static int id4 = 2;
    private final static String name = "Ivan";
    private final static String surname = "Ivanov";

    Set<EntityWithDefaultParam> def;
    Set<EntityWithCustomParam> custom;

    EntityWithDefaultParam def1;
    EntityWithDefaultParam def2;
    EntityWithDefaultParam def3;
    EntityWithDefaultParam def4;

    EntityWithCustomParam cast1;
    EntityWithCustomParam cast2;
    EntityWithCustomParam cast3;
    EntityWithCustomParam cast4;


    @Before
    public void setUpMainData() {
        def = new HashSet<>();
        custom = new HashSet<>();

        def1 = new EntityWithDefaultParam(id1, name, surname);
        def2 = new EntityWithDefaultParam(id2, name, surname);
        def3 = new EntityWithDefaultParam(id3, name, surname);
        def4 = new EntityWithDefaultParam(id4, name, surname);

        cast1 = new EntityWithCustomParam(id1, name, surname);
        cast2 = new EntityWithCustomParam(id2, name, surname);
        cast3 = new EntityWithCustomParam(id3, name, surname);
        cast4 = new EntityWithCustomParam(id4, name, surname);
    }


    @Test
    public void testForDefaultParamsMethod() throws Exception {
        def.add(def1);
        def.add(def2);
        def.add(def3);
        def.add(def4);
        Assert.assertEquals(def1.getId(), def3.getId());
        Assert.assertEquals(def2.getId(), def4.getId());
        Assert.assertEquals("Non parametrized hash and equals get incorrect result", def.size(), 4);
    }

    @Test
    public void testForCustomParamsMethod() throws Exception {
        custom.add(cast1);
        custom.add(cast2);
        custom.add(cast3);
        custom.add(cast4);

        Assert.assertEquals(cast1.getId(), cast3.getId());
        Assert.assertEquals(cast2.getId(), cast4.getId());
        Assert.assertEquals("Parametrized hash and equals get correct result", custom.size(), 2);

    }


    @After
    public void cleanResources(){
        Set<EntityWithDefaultParam> def = null;
        Set<EntityWithCustomParam> custom = null;

        EntityWithDefaultParam def1 = null;
        EntityWithDefaultParam def2 = null;
        EntityWithDefaultParam def3 = null;
        EntityWithDefaultParam def4 = null;

        EntityWithCustomParam cast1 = null;
        EntityWithCustomParam cast2 = null;
        EntityWithCustomParam cast3 = null;
        EntityWithCustomParam cast4 = null;
    }
}
