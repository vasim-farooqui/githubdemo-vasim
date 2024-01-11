#!groovy
def function_name 
{
   echo " function started stage2"
    agent {
        node {
            label 'DEPLOY_TEST_LAMBDA'
        }
    }
     

        stage('deploy on lambda') { 
            steps {
                echo " deploy code on lambda "
            }
        }
    
} 

def deployOnLAMBDA () {
    sh """
        echo "Deploying to Lambda" 
		  
		aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath   
        
    """
}
