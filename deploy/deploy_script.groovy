pipeline {
    agent any
    parameters {
        string(name: 'x1', defaultValue: 'default', description: 'This is a parameter')
    }
    stages {
        stage('Deploy') {
            steps {
                script {
                    def deployOnLAMBDA () {
                        sh ( label:"Deploying to Lambda", script: """
                             set +x
                             aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
                             aws lambda publish-version --function-name $lamfunction_name
                            """)
                    }
                    depScript.deployOnLAMBDA();
                }
            }
        }
    }
}
