package com.criticollab.bibframe.tools

import org.junit.Before
import org.junit.Test
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat
import org.semanticweb.owlapi.profiles.OWL2DLProfile

class TestValidate {
    private resource

    @Before
    void setUp() {
        resource = getClass().getResource("/bibframe.rdf.xml")
    }

    @Test
    void testValidateBibframeRFDXML() {
        boolean isValid = Validate.loadStrictly(this.resource,new RDFXMLDocumentFormat())
        org.junit.Assert.assertTrue("bibframe should parse",isValid)
    }

    @Test
    void testBibframeIsDL() {
        Validate.validateAgainstProfile(new OWL2DLProfile(),resource,new RDFXMLDocumentFormat())
    }
}
