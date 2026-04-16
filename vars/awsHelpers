def call(Map config = [:]) {
    // Centralized configuration - Move these to a 'consts' file or keep here
    def awsAccountId = "772064137213" // Replace with your actual ID
    def region       = "us-east-1"
    def repoName     = "devopsproject"
    def ecrUrl       = "${awsAccountId}.dkr.ecr.${region}.amazonaws.com"
    def fullImageUri = "${ecrUrl}/${repoName}"

    // Login to ECR
    sh "aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${ecrUrl}"

    // Tag and Push
    sh """
       docker tag studentapp:${config.appVersion} ${fullImageUri}:${config.appVersion}
       docker push ${fullImageUri}:${config.appVersion}
    """
}
