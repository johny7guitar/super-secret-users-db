package org.johny7guitar.supersecretusersdb.util;

import org.johny7guitar.supersecretusersdb.TestEntity;
import org.johny7guitar.supersecretusersdb.TestEntityWithName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityNameExtractorTest{

    @Test
    void entityNameExtractionFromAnnotationTest(){
        assertEquals("test_entity_name", EntityNameExtractor.get(TestEntityWithName.class));
    }

    @Test
    void entityNameExtractionFromClassNameTest(){
        assertEquals("TestEntity", EntityNameExtractor.get(TestEntity.class));
    }

    @Test
    void entityNameExtractionFromNonEntityTests(){
        assertNull(EntityNameExtractor.get(Object.class));
    }

}