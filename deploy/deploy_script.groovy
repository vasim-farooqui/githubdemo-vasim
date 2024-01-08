def deployOnECS () {
  
  //******** Following Variables need to come from jenkins ********
  //ECS_CLUSTER=qa-lrn-com
  //ECS_SERVICE=lrn-legacy-cm-email-service
  //TASK_DEFINATION=legacy-cm-email-service
  //AWS_REGION=us-east-1
  // Testing Jenkins Jira integration
  sh ( label:"Deploying to ECS", script: """
        set +x
        ECR_IMAGE=180350466832.dkr.ecr.us-east-1.amazonaws.com/lrn-container-repo:legacy-cm-email-service-\$GIT_COMMIT
        TASK_DEFINITION=\$(aws ecs describe-task-definition --task-definition \$TASK_DEFINATION)
        NEW_TASK_DEFINTIION=\$(echo \$TASK_DEFINITION | jq --arg IMAGE \$ECR_IMAGE '.taskDefinition | .containerDefinitions[0].image = \$IMAGE | del(.taskDefinitionArn) | del(.revision) | del(.status) | del(.requiresAttributes) | del(.compatibilities) | del(.registeredAt) | del(.registeredBy)')
        NEW_TASK_INFO=\$(aws ecs register-task-definition --region \$AWS_REGION --cli-input-json \"\$NEW_TASK_DEFINTIION\")
        NEW_REVISION=\$(echo \$NEW_TASK_INFO | jq '.taskDefinition.revision')
        aws ecs update-service --cluster \$ECS_CLUSTER  --service \$ECS_SERVICE --task-definition \$TASK_DEFINATION:\$NEW_REVISION --force-new-deployment | jq
  """)
