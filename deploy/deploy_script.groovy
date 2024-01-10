#!groovy

def deployOnLAMBDA () {
    sh  """
        echo "Deploying to Lambda" 
		  
        aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath    
        
    """
}
