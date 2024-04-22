pipeline {
    agent any
    stages {
        stage('Build Ingrediente') {
            steps {
                build job: 'api.ingrediente', wait: true
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }      
        stage('Build Image') {
            steps {
                script {
                    ingrediente = docker.build("pasilva2023/ingrediente:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential') {
                        ingrediente.push("${env.BUILD_ID}")
                        ingrediente.push("latest")
                    }
                }
            }
        }
    }
}