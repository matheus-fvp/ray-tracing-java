package org.example.unity_test;

import org.example.models.ObjModel;
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
        objModel.loadModel("./test/org/example/unity_test/testModel.obj");
        assertEquals(4, objModel.getVertices().size());
        assertEquals(3, objModel.getFaces().size());
    }


}
