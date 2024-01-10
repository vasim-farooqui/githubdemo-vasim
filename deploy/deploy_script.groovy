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
 } 

def loadCourseVersion () {
    sh """
        set +x
        aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
        aws lambda publish-version --function-name $lamfunction_name     
	
    """
}
