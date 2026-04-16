def call(Map config = [:]) {
    // Access the passed parameter using config.keyName
    def version = config.appVersion ?: 'latest'
    
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-cred']]) {
        sh """
            aws ecr get-login-password --region ${env.AWS_REGION} | \
            docker login --username AWS --password-stdin ${env.ACCOUNT_ID}.dkr.ecr.${env.AWS_REGION}.amazonaws.com
        """
        
        // Example: Using the version passed from the Jenkinsfile
        echo "Successfully logged in to ECR for version: ${version}"
    }
}
