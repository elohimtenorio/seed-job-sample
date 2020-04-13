// MyProject-Build.groovy

def gitUrl = "https://github.com/elohimtenorio/java-junit-sample.git"

job("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        git {
            remote {
                url gitUrl
                        branch "origin/master"
            }
            extensions {
                wipeOutWorkspace()
                localBranch "master"
            }
        }
    }
    steps {
        shell "echo \"I'm building master!\""
    }
}