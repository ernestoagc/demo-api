pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java'
    }
    environment {
        registry = "880382163732.dkr.ecr.us-east-1.amazonaws.com"
        repository_image="onlock-api"
    }

    stages {
        
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        
        stage('Git Clone') {
            steps{
                echo "Build number is ${currentBuild.number}"
                echo "cleaning..."
                cleanWs()
                echo "cloning"
                git branch: 'main', credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/ernestoagc/demo-api'    
            }
            
        }
        
        // Building Docker images
        stage('Building image') {
          steps{
            script {
                sh "pwd"
                echo "Inicia Build" 
                     sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin ${registry}'
					sh 'docker build -t ${registry}/${repository_image}:${BUILD_NUMBER} .'
          
            }
          }
        }
        
        // Uploading Docker images into AWS ECR
        stage('Pushing to ECR') {
         steps{  
             script {
                      sh '''
                      docker push ${registry}/${repository_image}:${BUILD_NUMBER}
                      '''
             }
            }
        }
        
		
		
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}