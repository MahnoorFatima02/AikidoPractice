pipeline {
    agent any
        environment {
            MAVEN_HOME = '/opt/homebrew/Cellar/maven/3.9.9/libexec'
            PATH = "${MAVEN_HOME}/bin:${env.PATH}"
        }
    stages {
        stage('Checkout') {
            steps {
                git 'git@github.com:MahnoorFatima02/AikidoPractice.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
