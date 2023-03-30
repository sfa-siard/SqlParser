package ch.enterag.sqlparser.identifier;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QualifiedIdTest {


    @Test
    public void shouldFormQualifiedId() {

        QualifiedId name = new QualifiedId(null, null, "name");
        assertEquals("\"name\"", name.format());
        assertEquals("\"sys\".\"name\"", new QualifiedId(null, "sys", "name").format());
    }
}