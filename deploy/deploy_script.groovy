def functionName = 'deployOnLAMBDA'

node('DEPLOY_TEST_LAMBDA'){

    stage('Deploy'){
        echo "deploy"
    }
    
}

def deployOnLAMBDA () {
    sh 'aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath
        aws lambda publish-version --function-name $lamfunction_name'
}
