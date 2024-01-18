def deployOnLAMBDA () {
        
                            sh ( label:"Deploying to Lambda", script: """
        set +x
  aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
  echo 'Function deployed"
  echo 'Waiting For Version Update'
  sleep(10)
  aws lambda publish-version --function-name $lamfunction_name
   """)
	
}
return this     
                
