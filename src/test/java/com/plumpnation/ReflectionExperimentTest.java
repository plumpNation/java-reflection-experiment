package com.plumpnation;

import org.junit.jupiter.api.Test;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionExperimentTest {
    @Test
    void testFindPersonAllFields() {
        Object something = new Person();

        Field[] declaredFields = something.getClass().getDeclaredFields();
        List<String> declaredFieldNames = getFieldNames(declaredFields);

        assertEquals(3, declaredFieldNames.size());
        assertTrue(declaredFieldNames.containsAll(Arrays.asList("name", "age", "yearOfBirth")));
    }

    @Test
    void testFindPersonPublicFields() {
        Object something = new Person();

        Field[] fields = something.getClass().getFields();
        List<String> fieldNames = getFieldNames(fields);

        assertEquals(1, fieldNames.size());
        assertTrue(fieldNames.contains("yearOfBirth"));
    }

    private List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
    }
}