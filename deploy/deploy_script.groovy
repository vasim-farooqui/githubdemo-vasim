#!groovy
def function_name 
{
   echo "function started stage2"
    agent {
        node {
            label 'DEPLOY_TEST_LAMBDA'
        }
    }
     environment {

           lamfunction_name = 'Jenkins-deployment-lamda'
           lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip' // Path to your updated Lambda function code

          } 

        stage('deploy on lambda') { 
            steps {
                echo " deploy code on lambda "
            }
        }
    
} 

def deployOnLAMBDA () {
    //check
  //******** Following Variables need to come from jenkins ********
  //ECS_CLUSTER=qa-lrn-com
  //ECS_SERVICE=lrn-legacy-cm-email-service
  //TASK_DEFINATION=legacy-cm-email-service
  //AWS_REGION=us-east-1
  // Testing Jenkins Jira integration
  //lamfunction_name = "Jenkins-deployment-lamda";
  //lambdafilepath = "/home/lrnqa/jenkins/workspace/Test-Lambda";
  sh ( label:"Deploying to Lambda", script: """
        set +x
  aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
  aws lambda publish-version --function-name $lamfunction_name
   """)
}
