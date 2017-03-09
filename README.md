Open Bibframe: A github repository for open review of the LC Bibframe Ontology
==============================================================================

Current status
--------------
The rdf/xml  ontology file is currently located in [ontology/src/main/resources/bibframe.rdf.xml](https://github.com/sesuncedu/bibframe-ontology/blob/master/ontology/src/main/resources/bibframe.rdf.xml)

Errors fixed so far:
---------------------

1. Use of incorect term owl:SymmetricalProperty replaced by owl:SymmetricProperty
2. Declarations added for undeclared annotation properties  from skos and dcterms.
3. Declaration for foaf:Person as OWL class added.

Known Syntax errors not yet fixed:
---------------------------
 1. No declared class bf:ContentAccessability  

Current Profile Violations
--------------------------
* Use of undeclared class: <http://id.loc.gov/ontologies/bibframe/ContentAccessability> [ObjectPropertyRange(<http://id.loc.gov/ontologies/bibframe/contentAccessibility> <http://id.loc.gov/ontologies/bibframe/ContentAccessability>) in OntologyID(OntologyIRI(<http://id.loc.gov/ontologies/bibframe/>) VersionIRI(<null>))]
