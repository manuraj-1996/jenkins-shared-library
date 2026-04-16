def call(Map config = [:]) {
    // Provide default values if they aren't passed
    def imageName = config.imageName ?: env.IMAGE_NAME
    def appVersion = config.appVersion ?: env.APP_VERSION
    def dockerfile = config.dockerfile ?: "Dockerfile"

    echo "Building Docker Image: ${imageName}:${appVersion} using ${dockerfile}"

    sh "docker build -f ${dockerfile} -t ${imageName}:${appVersion} ."
}
