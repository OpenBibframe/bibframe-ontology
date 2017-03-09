package com.criticollab.bibframe.tools

import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.io.*
import org.semanticweb.owlapi.model.*
import org.semanticweb.owlapi.profiles.OWLProfile
import org.semanticweb.owlapi.profiles.OWLProfileReport
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Validate {
    private static Logger logger = LoggerFactory.getLogger(Validate.class)

    static OWLOntology loadStrictly(input, OWLDocumentFormat format = null) {
        OWLOntologyDocumentSource documentSource = null

        switch (input) {
            case File:
                documentSource = new FileDocumentSource((File) input, format)
                break;
            case URL:
                URL url = (URL) input
                documentSource = new StreamDocumentSource(url.newInputStream(), IRI.create(url), format, null)
                break
            case String:
                documentSource = new FileDocumentSource(new File((String) input), format)
                break
            default:
                throw new IllegalArgumentException("input should be a File, URL, or String")
        }

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager()
        OWLOntologyLoaderConfiguration loaderConfiguration = manager.getOntologyLoaderConfiguration()
        loaderConfiguration.strict = true
        OWLOntology ontology
        ontology = manager.loadOntologyFromOntologyDocument(documentSource, loaderConfiguration)
        def format2 = manager.getOntologyFormat(ontology)
        def data = format2.ontologyLoaderMetaData
        if (data.isPresent()) {
            OWLOntologyLoaderMetaData metaData = data.get()
            if (metaData.unparsedTriples.count() != 0) {
                metaData.unparsedTriples.forEach { x -> logger.error("unparsed triple, {} ", x) }
            }
            throw new OWLParserException("unparsed triples in document");
        }

        return ontology
    }

    static boolean validateAgainstProfile(OWLProfile profile, input, format = null){
        OWLOntology ontology
        switch (input) {
            case OWLOntology:
                ontology = input
                break;
            default:
                ontology = loadStrictly(input, format)
        }

        OWLProfileReport report = profile.checkOntology(ontology)

        if (!report.violations.isEmpty()) {
            logger.error("Profile violations: {}", report.violations)
        }
        return report.inProfile
    }

}
