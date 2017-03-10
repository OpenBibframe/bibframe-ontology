package com.criticollab.bibframe.tools

import org.junit.Before
import org.junit.Test
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat
import org.semanticweb.owlapi.profiles.OWL2DLProfile

import static org.junit.Assert.assertTrue
//@Ignore
class TestValidate {
    private URL resource

    @Before
    void setUp() {
         resource = getClass().getResource("/bibframe-fixed.rdf.xml")
    }

    @Test
    void testValidateBibframeRFDXML() {
        boolean isValid = Validate.loadStrictly(this.resource,new RDFXMLDocumentFormat())
        assertTrue("bibframe should parse",isValid)
    }

    @Test
    void testBibframeIsDL() {
        assertTrue(Validate.validateAgainstProfile(new OWL2DLProfile(),resource,new RDFXMLDocumentFormat()))
    }
}
