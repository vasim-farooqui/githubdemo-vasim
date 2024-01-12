def deployOnLAMBDA () {
    echo "Deploying to Lambda"
}
  node {
    label 'DEPLOY_TEST_LAMBDA'
    stage('Deploy') {
        sh '''
                    aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath

                  '''
    }
}
 
    
