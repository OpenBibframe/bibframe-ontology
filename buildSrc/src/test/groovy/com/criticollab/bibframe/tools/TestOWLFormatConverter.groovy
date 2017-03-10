package com.criticollab.bibframe.tools

import org.junit.Test
import org.semanticweb.owlapi.formats.TurtleDocumentFormat

import static org.junit.Assert.assertNotNull

class TestOWLFormatConverter {

    @Test void testConvertToTurtle() {
        String f = getClass().getResource("/bibframe-fixed.rdf.xml").file
        File file = new File(f)
        File tempDir = File.createTempDir()
        File out = OWLFormatConverter.convert(file,tempDir,new TurtleDocumentFormat())
        assertNotNull(out)
    }

}
