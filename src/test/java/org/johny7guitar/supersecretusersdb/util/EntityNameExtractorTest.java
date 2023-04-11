package org.johny7guitar.supersecretusersdb.util;

import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

import static org.junit.jupiter.api.Assertions.*;

class EntityNameExtractorTest{

    @Entity(name = "test_entity_name") private static class TestEntityWithName{};
    @Entity private static class TestEntityWithoutName{};


    @Test
    void entityNameExtractionFromAnnotationTest(){
        assertEquals("test_entity_name", EntityNameExtractor.get(TestEntityWithName.class));
    }

    @Test
    void entityNameExtractionFromClassNameTest(){
        assertEquals("TestEntityWithoutName", EntityNameExtractor.get(TestEntityWithoutName.class));
    }

    @Test
    void entityNameExtractionFromNonEntityTests(){
        assertNull(EntityNameExtractor.get(Object.class));
    }

}