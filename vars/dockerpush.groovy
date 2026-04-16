def call(Map config = [:]) {
    // 1. Extract values from config map or environment
    def localImage = config.localImage ?: "${env.IMAGE_NAME}:${env.APP_VERSION}"
    def remoteRepo = config.remoteRepo ?: env.ECR_URL
    def tag        = config.tag        ?: env.APP_VERSION

    echo "Tagging and Pushing ${localImage} to ${remoteRepo}..."

    sh """
        # Tag the specific version
        docker tag ${localImage} ${remoteRepo}:${tag}
        
        # Best practice: Also tag as 'latest' for the deployment scripts
        docker tag ${localImage} ${remoteRepo}:latest
        
        # Push both to ECR
        docker push ${remoteRepo}:${tag}
        docker push ${remoteRepo}:latest
    """
}
