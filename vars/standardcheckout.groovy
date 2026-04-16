def call() {
    checkout([
        $class: 'GitSCM',
        branches: [[name: '*/main']],
        userRemoteConfigs: [[
            url: 'https://github.com/manuraj-1996/Test.git',
            credentialsId: 'Githubtoken'
        ]]
    ])
}
