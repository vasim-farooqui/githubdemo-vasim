```groovy
pipeline {
    agent any

    environment {
        //AWS_ACCESS_KEY_ID = credentials('YOUR_AWS_ACCESS_KEY_ID')
        //AWS_SECRET_ACCESS_KEY = credentials('YOUR_AWS_SECRET_ACCESS_KEY')
        AWS_DEFAULT_REGION = 'us-east-1'
        lamfunction-name = 'Jenkins-deployment-lamda'
        LAMBDA_HANDLER = 'jenkins'
        lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip' // Path to your updated Lambda function code
    }

    stages {
        stage('Update Lambda Function') {
            steps {
                script {
                    // Configure AWS CLI credentials

                     {
                        // Update Lambda function code
                        sh "aws lambda update-function-code --function-name ${env.lamfunction-name} --zip-file fileb://${env.lambdafilepath}"

                        // Publish a new version of the Lambda function
                        def result = sh(script: "aws lambda publish-version --function-name ${env.lamfunction-name}", returnStdout: true).trim()
                        def version = sh(script: "echo ${result} | jq -r '.Version'", returnStdout: true).trim()
                        println "New version published: $version"
                    }
                }
            }
        }
    }
}
```

