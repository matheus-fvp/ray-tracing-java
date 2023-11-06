package org.example.unit_test;

import org.example.models.Face;
import org.example.models.ObjModel;
import org.example.models.Vertex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjModelTest {
    private ObjModel objModel;

    @Before
    public void setUp() {
        objModel = new ObjModel();
    }

    @Test
    public void mustLoadAObjModel() {
        objModel.loadModel("src/test/java/org/example/unit_test/testModel.obj");
        assertEquals(4, objModel.getVertices().size());
        assertEquals(3, objModel.getFaces().size());
    }


}
