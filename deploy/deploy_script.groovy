#!groovy

def function
{

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
	  
  stage('Code Deploy On lambda') { 
      steps { 
	      
        echo " stage started "       
        }
     }
   }	
}
def deployOnLAMBDA () {
    sh """
        echo "Deploying to Lambda" 
		  
		aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath   
        
    """
}

