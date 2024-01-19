def deployOnLAMBDA () {
        
                sh ( label:"Deploying to Lambda", script: """
                set +x
                echo "Waiting For Version Update"
                aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
              """ )	
}
return this 
def Newversion () {
        sh ( label:"New version creation", script: """
                set +x
                echo "Waiting For Version Update"
                aws lambda publish-version --function-name $lamfunction_name
              """ )	
}        
return this 
