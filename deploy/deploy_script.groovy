#!groovy
pipeline {
    agent any
 
    environment {
        LAMBDA_FUNCTION_NAME = 'Jenkins-deployment-lamda'
        ZIP_FILE_PATH = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip'
    }
 
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
 
        stage('Update Lambda Function') {
            steps {
                script {
                    // Assuming your AWS CLI is configured on the Jenkins instance with an IAM role that has Lambda update permissions
                    sh "aws lambda update-function-code --function-name ${LAMBDA_FUNCTION_NAME} --zip-file fileb://${ZIP_FILE_PATH}"
                }
            }
        }
 
        stage('Cleanup') {
            steps {
                script {
                    // Clean workspace after the build
                    cleanWs()
                }
            }
        }
    }
 
    post {
        always {
            // Clean up even if the build fails
            cleanWs()
        }
    }
}
