pipeline {
  agent any
    environment { 
        lamfunction_name = 'Jenkins-deployment-lamda'
        lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip'
    }
    node {
      label 'DEPLOY_TEST_LAMBDA'
    }
  
  stages {
    stage('Deploy') {
      steps {
        script {
          def depScript = load ('deploy/deploy_script.groovy')
          depScript.deployOnLAMBDA();
        }
      }
    }
  }
}
def deployOnLAMBDA () {
                        sh ( label:"Deploying to Lambda", script: """
                             set +x
                             aws lambda update-function-code --function-name $lamfunction_name --zip-file fileb://$lambdafilepath
                             aws lambda publish-version --function-name $lamfunction_name
                            """)
                    }
         
                
