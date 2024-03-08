pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Containerize') {
            steps {

                // Run Maven Wrapper Commands
                sh "docker build -t myapp ."

                echo 'Containerizing the App with Docker'
            }
        }
        stage('Deploy') {
    steps {
        script {
            // Check if the container is already running
            def isRunning = sh(script: 'docker ps -q -f name=pets-container', returnStatus: true)
            if (isRunning == 0) {
                echo 'Pets container is already running. Stopping it...'
                // Stop the container if it's running
                sh 'docker stop pets-container'
            }
            
            // Remove the container if it exists
            sh 'docker rm -f pets-container || true'
            
            // Run the Docker container
            sh "docker run --name pets-container -d -p 9090:9090 myapp"
            
            echo 'Deploy the App with Docker'
        }
    }
}
        
    }
}
