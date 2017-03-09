Open Bibframe: A github repository for open review of the LC Bibframe Ontology
==============================================================================

Current status
--------------
The rdf/xml  ontology file is currently located in [ontology/src/main/resources/bibframe.rdf.xml](https://github.com/sesuncedu/bibframe-ontology/blob/master/ontology/src/main/resources/bibframe.rdf.xml)

This file is now legal OWL 2 DL.

Errors fixed so far:
---------------------

1. Use of incorect term owl:SymmetricalProperty replaced by owl:SymmetricProperty
2. Declarations added for undeclared annotation properties  from skos and dcterms.
3. Declaration for foaf:Person as OWL class added.
4. Declaration for foaf:Agent added.
5. All uses of rdfs:Resource changed to owl:Thing.
6. Typo of bf:ContentAccessability instead of bf:ContentAccessibility fixed

Known OWL problems
--------------
1. Some places where rdfs:Resource was being used should probably be replaced by a data property using xsd:anyUri.
2. Many properties lack domains or ranges. Sometimes these ranges are improper
