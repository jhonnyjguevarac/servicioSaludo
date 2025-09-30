pipeline {
    agent any
   environment {
        PATH = "C:/Program Files/Docker/Docker/resources/bin;$PATH"
    }
    tools {
        maven 'Maven3'    // Nombre EXACTO configurado en Jenkins -> Global Tool Configuration
        jdk 'Java17'      // O el que hayas configurado (ej: Java17)
    }

    stages {
        stage('Checkout') {
     steps {
                git branch: 'master', url: 'https://github.com/jhonnyjguevarac/servicioSaludo.git', credentialsId: 'd8e1ec9f-125f-4eab-ae89-c073185da870'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t servicio1 .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker stop servicio1 || true && docker rm servicio1 || true'
                sh 'docker run -d -p 8081:8081 --name servicio1 servicio1'
            }
        }
    }
}