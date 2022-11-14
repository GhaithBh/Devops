pipeline {
    
    environment { 
        registry = "fatimetouu19/devops_project1" 
        registryCredential = 'dockerhub_id' 
        dockerImage = '' 
    }


    agent any

    stages {
        
                stage('git') {
            steps {
            
                git branch: 'fatima', url: 'https://github.com/GhaithBh/Devops.git',
                credentialsId:"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";
                
            }
}
       stage('Cleaning'){
            steps {
               sh """mvn clean"""
            }
        }
       stage('Compiling'){
            steps {
               sh """mvn compile"""
            }
        }
        
      stage("packaging"){
            steps {
                sh """mvn package -e"""
                
            }
        }
      stage("SONARQUBE"){
            steps {
                sh """mvn sonar:sonar -Dsonar.login=a3b0ece5ce9ed145307202b25877e362e8652716 -Dsonar.host.url=http://192.168.1.11:9000"""
                
            }
        }
        stage("Junit/Mockito"){
            steps {
                sh """mvn test """
                
            }
        }
        stage ('Publish to Nexus') {
            steps {
                sh """mvn deploy -e"""
                
            }
        }
        
        stage('Building our image') { 
            steps {
                script { 
                    dockerImage = docker.build registry 
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script {
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push()
                    }
                } 
            }
        } 
        stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry" 
            }
        } 
        stage('Running app') { 
            steps { 
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
                sh "docker-compose up -d" 
            }
        } 
        

    }
    post{
        failure{
            emailext to: "fatimetouche07@gmail.com",
            subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
        }
    }
}
