package org.example.unit_test;

import org.example.models.ObjLoader;
import org.junit.Before;
import org.junit.Test;

public class ObjModelTest {
    private ObjLoader objModel;

    @Before
    public void setUp() {
        objModel = new ObjLoader();
    }

    @Test
    public void mustLoadAObjModel() {
        objModel.loadModel("src/test/java/org/example/unit_test/testModel.obj");
        assertEquals(4, objModel.getVertices().size());
        assertEquals(3, objModel.getFaces().size());
    }


}
