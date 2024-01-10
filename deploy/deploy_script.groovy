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
                    def awsCliPath = tool 'AWS_CLI'
                    sh "${awsCliPath}/aws lambda update-function-code --function-name ${lamfunction_name} --zip-file ${lambdafilepath}"
                }
            }
        }
    }
}
