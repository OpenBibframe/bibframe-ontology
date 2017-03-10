package com.criticollab.bibframe.tools

import org.gradle.api.internal.AbstractTask
import org.gradle.api.tasks.*
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.OWLDocumentFormat
import org.semanticweb.owlapi.model.OWLException
import org.semanticweb.owlapi.profiles.OWLProfile
import org.semanticweb.owlapi.profiles.Profiles

class ValidateTask extends AbstractTask {
    @InputFile
    def file
    @Optional
    @Input
    def format
    @Optional
    @Input
    def profile
   @OutputFile
    private File foo = new File(project.buildDir,"stub")
    @TaskAction
    validate(IncrementalTaskInputs inputs) {
        println inputs.properties
        if (inputs.incremental) {
            boolean changed=false
            inputs.outOfDate({
                logger.debug it.properties
                changed = changed || it.added || it.modified || it.removed
            })
            if(!changed) {
                logger.debug "no changes"
                return
            }
        }
        OWLProfile owlProfile = null
        if (!profile) {
            owlProfile = Profiles.OWL2_DL.OWLProfile
        } else {
            switch (profile) {
                case OWLProfile:
                    owlProfile = profile
                    break;
                case String:
                    owlProfile = Profiles.valueOf(profile).OWLProfile
                    break;
                default:
                    throw new IllegalArgumentException("profile must be String or OWLProfile")
            }
        }
        OWLDocumentFormat documentFormat = null
        if (format) {
            switch (format) {
                case OWLDocumentFormat:
                    documentFormat = format
                    break
                case String:
                    OWLManager.createOWLOntologyManager().getOntologyParsers().each {
                        if (format == it.supportedFormat.key) {
                            documentFormat = it.supportedFormat
                        }
                    }
                    break;
                default:
                    throw new OWLException("format should be String or OWLDocumentFormat")
            }
        }
        if (!Validate.validateAgainstProfile(owlProfile, file, documentFormat)) {
            throw new OWLException("could not validate $file against $owlProfile / ${documentFormat?.key}")
        }
    }
}
