import xyz.cofe.io.fn.IOFun

println "putdll"
println "="*40
println "project"
println project

println "\nproperties:"
println project.properties

println "\nartifacts:"
project.getArtifacts().each { artifact ->
    println artifact
    if( artifact.type in ['dll'] && artifact.file.exists() ){
        println "found $artifact.file"
        File target = new File("$project.basedir/src/main/resources/jacob-dll/$artifact.file.name")
        if( !target.exists() ) {
            File dir = target.getParentFile()
            if( dir!=null && !dir.exists() ){
                if( dir.mkdirs() ){
                    println "mkdir $dir"
                }
            }

            artifact.file.withInputStream { instrm ->
                target.withOutputStream{ outstrm ->
                    IOFun.copy(instrm,outstrm)
                }
            }
            println "copied $target"
        }
    }
}