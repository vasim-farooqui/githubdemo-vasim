#!groovy

pipeline {

  agent { 
    node {
      label 'DEPLOY_TEST_LAMBDA'
    }
  }
	
  environment {
        //AWS_ACCESS_KEY_ID = credentials('YOUR_AWS_ACCESS_KEY_ID')
        //AWS_SECRET_ACCESS_KEY = credentials('YOUR_AWS_SECRET_ACCESS_KEY')
        AWS_DEFAULT_REGION = 'us-east-1'
        lamfunction-name = 'Jenkins-deployment-lamda'
        LAMBDA_HANDLER = 'jenkins'
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
