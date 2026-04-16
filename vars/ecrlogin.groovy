// vars/projectconfig.groovy
def call() {
    return [
        ecr_url: '772064137213.dkr.ecr.us-east-1.amazonaws.com/devopsproject',
        aws_creds: 'aws-cred' // <--- MUST match the ID in Jenkins Credentials
    ]
}
