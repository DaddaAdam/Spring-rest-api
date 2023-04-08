pipeline {
    agent any

    environment {
        PATH = "$PATH:/usr/local/bin"
    }

    stages {
        stage('Copy Application.Properties') {
            steps {
                sh 'mkdir ${WORKSPACE}/src/main/resources'
                sh 'cp ~/application.properties ${WORKSPACE}/src/main/resources/application.properties'
            }
        }
        stage('Build Docker image') {
            steps {
                git 'https://github.com/DaddaAdam/Spring-rest-api.git'
                sh './mvnw -N io.takari:maven:wrapper'
                sh 'docker build -t daddaadam/spring-api .'
            }
        }
        stage('Push Docker image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                    sh 'docker push daddaadam/spring-api'
                }
            }
        }
    }
}
