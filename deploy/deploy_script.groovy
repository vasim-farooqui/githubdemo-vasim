#!groovy
def functionName = 'deployOnLAMBDA'

node('DEPLOY_TEST_LAMBDA'){

    stage('Deploy'){
        echo "deploy"
    }
    
}

def deployOnLAMBDA () {
    echo "test"
}
