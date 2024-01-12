def deployOnLAMBDA () {
    echo "Deploying to Lambda"
}
agent any
 environment {
        lamfunction_name = 'Jenkins-deployment-lamda'
        lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip' // Path to your updated Lambda function code
        }
stages {
	  
  stage('Code Deploy On lambda') { 
      steps { 
	      
        sh '''
	
        aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath
        aws lambda publish-version --function-name $lamfunction_name 
	
          '''        
        }
     }
   }
