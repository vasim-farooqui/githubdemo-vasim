#!groovy

pipeline {

  agent { 
    node {
      label 'DEPLOY_TEST_LAMBDA'
    }
  }
 
  environment {
        lamfunction_name = 'Jenkins-deployment-lamda'
        lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip' // Path to your updated Lambda function code
    }  
  stages {
	  
  stage('Code Deploy Or lambda') { 
      steps { 
        sh {
        aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath
        aws lambda publish-version --function-name $lamfunction_name 
         }
      }
    }
	
 } 



