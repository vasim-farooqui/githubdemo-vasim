def deployOnLAMBDA () {
        
                sh ( label:"Deploying to Lambda", script: """
                set +x
                echo "Waiting For Version Update"
                aws lambda publish-version --function-name $lamfunction_name
              """ )	
}
return this 

