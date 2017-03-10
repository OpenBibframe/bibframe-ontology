package com.criticollab.bibframe.tools

import org.junit.Ignore
import org.junit.Test
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat

/**
 * Created by ses on 3/10/17.
 */
class TestValidateTask {
    @Ignore
    @Test
    public void testBasic() {
        ValidateTask task = new ValidateTask()
        task.configure {
            String f = getClass().getResource("/bibframe-fixed.rdf.xml").file
            file=new File(f)
            format=new RDFXMLDocumentFormat()
        }
        println task.properties
    }
}
