Open Bibframe: A github repository for open review of the LC Bibframe Ontology
==============================================================================

Current status
--------------

###Errors fixed so far:

1. Use of incorect term owl:SymmetricalProperty replaced by owl:SymmetricProperty
2. Declarations added for undeclared annotation properties  from skos and dcterms.
3. Declaration for foaf:Person as OWL class added.
4. Declaration for foaf:Agent added.
5. All uses of rdfs:Resource changed to owl:Thing.
6. Typo of bf:ContentAccessability instead of bf:ContentAccessibility fixed

###Known OWL issues
1. Some places where rdfs:Resource was being used should probably be replaced by a data property using xsd:anyUri.
2. Many properties lack domains or ranges. Sometimes the domain or range is given in a comment, instead of as an axiom.

##Syntactically Valid File
A fixed version of the original rdf/xml  ontology file is currently located at
 [bibframe.rdf.xml](https://github.com/sesuncedu/bibframe-ontology/blob/master/ontology/src/main/resources/bibframe.rdf.xml)
This file is now legal OWL.

##Renderings

The modified file has been rendered in a variety of formats, using OWLAPI/Protégé.

### Manchester OWL Syntax  - [bibframe-protege.omn](ontology/src/main/resources/bibframe-protege.omn) 

```
ObjectProperty: bf:absorbed

    Annotations: 
        dcterms:modified "2016-04-29 (added inverse, updated range)",
        rdfs:label "Absorption of",
        skos:definition "Resource that has been incorporated into another resource.",
        dcterms:modified "2016-04-21 (New)",
        rdfs:comment "Expected value Work or Instance",
        rdfs:comment "Used with Work or Instance"
    
    SubPropertyOf: 
        bf:precededBy
    
    InverseOf: 
        bf:absorbedBy
        
```

### Functional Style Syntax - [bibframe-protege.ofn](ontology/src/main/resources/bibframe-protege.ofn)
 
```

# Object Property: bf:absorbed (Absorption of)
   
   AnnotationAssertion(dcterms:modified bf:absorbed "2016-04-21 (New)")
   AnnotationAssertion(dcterms:modified bf:absorbed "2016-04-29 (added inverse, updated range)")
   AnnotationAssertion(rdfs:comment bf:absorbed "Expected value Work or Instance")
   AnnotationAssertion(rdfs:comment bf:absorbed "Used with Work or Instance")
   AnnotationAssertion(rdfs:label bf:absorbed "Absorption of")
   AnnotationAssertion(skos:definition bf:absorbed "Resource that has been incorporated into another resource.")
   SubObjectPropertyOf(bf:absorbed bf:precededBy)
   InverseObjectProperties(bf:absorbed bf:absorbedBy)
```

### Turtle - [bibframe-protege.ttl](ontology/src/main/resources/bibframe-protege.ttl) 
 
```
###  http://id.loc.gov/ontologies/bibframe/absorbed
bf:absorbed rdf:type owl:ObjectProperty ;
            rdfs:subPropertyOf bf:precededBy ;
            owl:inverseOf bf:absorbedBy ;
            dcterms:modified "2016-04-21 (New)" ,
                             "2016-04-29 (added inverse, updated range)" ;
            rdfs:comment "Expected value Work or Instance" ,
                         "Used with Work or Instance" ;
            rdfs:label "Absorption of" ;
            skos:definition "Resource that has been incorporated into another resource." .
```
### RDF/XML - [bibframe-protege.rdf.xml](ontology/src/main/resources/bibframe-protege.rdf.xml) 

 
 ```xml
 <!-- http://id.loc.gov/ontologies/bibframe/absorbed -->

    <owl:ObjectProperty rdf:about="http://id.loc.gov/ontologies/bibframe/absorbed">
        <rdfs:subPropertyOf rdf:resource="http://id.loc.gov/ontologies/bibframe/precededBy"/>
        <owl:inverseOf rdf:resource="http://id.loc.gov/ontologies/bibframe/absorbedBy"/>
        <dcterms:modified>2016-04-21 (New)</dcterms:modified>
        <dcterms:modified>2016-04-29 (added inverse, updated range)</dcterms:modified>
        <rdfs:comment>Expected value Work or Instance</rdfs:comment>
        <rdfs:comment>Used with Work or Instance</rdfs:comment>
        <rdfs:label>Absorption of</rdfs:label>
        <skos:definition>Resource that has been incorporated into another resource.</skos:definition>
    </owl:ObjectProperty>
``` 
 

