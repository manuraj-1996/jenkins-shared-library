def call(Map config = [:]) {
    def region = config.region ?: env.AWS_REGION
    def registryUrl = "https://${config.accountId ?: env.ACCOUNT_ID}.dkr.ecr.${region}.amazonaws.com"
    
    // This plugin-based method handles the token exchange automatically
    docker.withRegistry(registryUrl, "ecr:${region}:${config.credentialsId ?: 'aws-cred'}") {
        echo "Successfully logged into ECR"
    }
}
