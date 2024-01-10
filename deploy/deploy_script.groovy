pipeline {
    agent any

         environment {

           lamfunction_name = 'Jenkins-deployment-lamda'
           lambdafilepath = '/home/lrnqa/jenkins/workspace/Test-Lambda/lamdbacode.zip' // Path to your updated Lambda function code

          } 

    stages {
        
        stage("Deploy")  {
            
            steps  {
                sh '''
                    aws lambda update-function-code --function-name $lamfunction_name --zip-file $lambdafilepath

                  '''
                }
             }

        stage("version") {
            steps {
                  
                  sh '''
                   aws lambda publish-version --function-name $lamfunction_name

                   '''                  
                }
           }
       }
    
}
