def deployOnLAMBDA () {
    echo "Deploying to Lambda"
}

    agent any
 
    stages {
        stage('Hello') {
            steps {
                sh '''
                    aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath

                  '''
            }
        }
    }

