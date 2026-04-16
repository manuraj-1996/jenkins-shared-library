// vars/dockerBuild.groovy
def call(Map config = [:]) {
    // 1. Extract values with safe fallbacks
    // The 'config.key ?: default' syntax is good, but we add a check later
    def imageName  = config.imageName  ?: env.IMAGE_NAME
    def appVersion = config.appVersion ?: env.APP_VERSION
    def dockerfile = config.dockerfile ?: "Dockerfile"

    // 2. Fail-Fast Validation (The "Anti-Null" Guard)
    if (!imageName || !appVersion) {
        error "BUILD FAILURE: imageName ('${imageName}') or appVersion ('${appVersion}') is null. " +
              "Please define them in the environment {} block or pass them as parameters."
    }

    // 3. Execution
    echo "--- Starting Docker Build ---"
    echo "Image: ${imageName}"
    echo "Tag:   ${appVersion}"
    echo "File:  ${dockerfile}"

    // Use string interpolation carefully to ensure no hidden spaces
    sh "docker build -f ${dockerfile.trim()} -t ${imageName.trim()}:${appVersion.trim()} ."
}
