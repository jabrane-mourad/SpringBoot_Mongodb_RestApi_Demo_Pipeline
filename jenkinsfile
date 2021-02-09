pipeline {
    agent any

    stages {
        stage('SCM checkout') {
            steps {
                echo 'getting from github'
                echo 'checout completed'
            }
        }
        stage('Build') {
            steps {
                echo 'Build completed'
            }
        }
        stage('Test') {
            steps {
                sh 'date'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy completed'
            }
        }
    }
}
