package com.criticollab.bibframe.tools

import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat
import org.semanticweb.owlapi.formats.ManchesterSyntaxDocumentFormat
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat
import org.semanticweb.owlapi.formats.TurtleDocumentFormat
import org.semanticweb.owlapi.io.FileDocumentTarget
import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget
import org.semanticweb.owlapi.model.OWLDocumentFormat

class OWLFormatConverter {
    static convert(File src, File destDir, OWLDocumentFormat format) {
        def manager = OWLManager.createOWLOntologyManager()
        def ontology = manager.loadOntologyFromOntologyDocument(src)
        def baseName = src.name
        int pos
        if(baseName.endsWith(".rdf.xml")) {
            pos = baseName.lastIndexOf(".rdf.xml")
        } else {
            pos = baseName.lastIndexOf('.')
        }
        if (pos >= 0) {
            baseName = baseName.substring(0, pos)
        }
        def outFile = new File(destDir, baseName + extensionForFormat(format))
        OWLOntologyDocumentTarget target = new FileDocumentTarget(outFile)
        manager.saveOntology(ontology, format, target)
        return outFile
    }

    static String extensionForFormat(OWLDocumentFormat format) {
        switch (format) {
            case RDFXMLDocumentFormat:
                return ".rdf.xml"
            case TurtleDocumentFormat:
                return ".ttl"
            case FunctionalSyntaxDocumentFormat:
                return ".ofn"
            case ManchesterSyntaxDocumentFormat:
                return ".omn"
            default:
                return ".owl"
        }
    }
}
