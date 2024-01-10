#!groovy

pipeline {

    agent {
        node {
            label 'DEPLOY_TEST_LAMBDA'
        }
    }
  
    stages {

        stage('deploy on lambda') { 
            steps {
                echo " deploy code on lambda "
            }
        }         
        
    } // Stages close
    
} 
def deployOnLAMBDA () {
    sh  """
        echo "Deploying to Lambda" 
		  
        aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath    
        
    """
}
