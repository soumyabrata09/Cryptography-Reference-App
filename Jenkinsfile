pipeline {
    agent any
    triggers {
        pollSCM '5 * * * *' /*runs every 5 minutes */
    }
    stages {
        stage('Build') {
            steps {
                sh([script: './mvnw -e clean install -DskipTests'])
            }
        }
        stage('Test') {
            steps {
                sh([script: './mvnw clean test'])
            }
        }
    }
}