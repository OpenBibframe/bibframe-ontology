package com.criticollab.bibframe.tools

import org.gradle.api.internal.AbstractTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.semanticweb.owlapi.model.OWLDocumentFormat

/**
 * Created by ses on 3/10/17.
 */
class OWLFormatConvertTask extends  AbstractTask {
    @InputFile File src
    @OutputDirectory File destDir
    @Input formats

    @TaskAction exec() {
        if(formats instanceof OWLDocumentFormat) {
            OWLFormatConverter.convert(src,destDir,formats)
        } else if (formats instanceof Iterable) {
            formats.each {
                OWLDocumentFormat df = it as OWLDocumentFormat
                logger.info "converting {} to {}",src,df.key
                OWLFormatConverter.convert(src,destDir,df)
            }
        }
    }
}
