def sleep
def deployOnLAMBDA () {
        
                sh ( label:"Deploying to Lambda", script: """
                set +x
                aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
                echo "Waiting For Version Update"
                aws lambda publish-version --function-name $lamfunction_name
              """ )	
}
return this     
                
