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

        stage('deploy on lambda') { 
            steps {
                echo " deploy code on lambda "
            }
        }

        stage('version') { 
            steps { 
                echo " new version " 
            }
            
        }
	  
          
        
    } // Stages close
    
} 



def deployOnLAMBDA () {
    sh """
        echo "Deploying to Lambda" 
		  
		  aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath
		          
    
        
    """
}
