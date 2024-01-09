def deployOnLAMBDA () {
  //check
  //******** Following Variables need to come from jenkins ********
  //ECS_CLUSTER=qa-lrn-com
  //ECS_SERVICE=lrn-legacy-cm-email-service
  //TASK_DEFINATION=legacy-cm-email-service
  //AWS_REGION=us-east-1
  // Testing Jenkins Jira integration
  function-name = Jenkins-deployment-lamda
  lambdafilepath = "/home/lrnqa/jenkins/workspace/Test-Lambda"
  sh ( label:"Deploying to Lambda", script: """
        set +x
  aws lambda update-function-code --function-name $function-name --zip-file fileb://$lambdafilepath
  aws lambda publish-version --function-name $function-name 
   """)
}
