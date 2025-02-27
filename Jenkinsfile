pipeline {
    agent any
        environment {
            MAVEN_HOME = '/opt/homebrew/Cellar/maven/3.9.9/libexec'
            PATH = "${MAVEN_HOME}/bin:${env.PATH}"
        }
    stages {
        stage('Checkout') {
            steps {
                           git branch: 'main', url: 'git@github.com:MahnoorFatima02/AikidoPractice.git'
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

        stage ('Test & Coverage'){
            steps {
                sh 'mvn test jacoco:report'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    jacoco(execPattern: 'target/jacoco.exec')
                }
            }
        }
    }
}
