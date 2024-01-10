pipeline {

    agent any
 
    environment {

        lamfunction_name = 'Jenkins-deployment-lamda'

        lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip'

    }
 
    stages {

        stage("deployOnLAMBDA") {

            steps {

                script {

                    sh '''

                        aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath

                    '''

                }

            }

        }

    }

}
