pipeline {

    agent any

    stages {
        stage('Getting project from Github') {
            steps {
                git branch : 'Iheb' ,
                    url : 'https://github.com/GhaithBh/Devops.git',
                    credentialsId:"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";
            }
        }
        stage('database connection') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
            }
        }
        stage('cleanig the project') {
            steps{
                sh 'mvn clean'
            }

        }
        stage ('artifact construction') {
            steps{
                sh 'mvn  package'
            }
        }
        stage ('Unit Test') {
            steps{
                sh 'mvn  test'
            }
        }
        stage ('SonarQube analysis') {
            steps{
                sh '''
                mvn sonar:sonar
                '''
            }
        }
        stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        }
        stage('Build Docker Image with new code') {
      // build docker image
      dockerImage = docker.build("ihebhamdi/devops")
    }
    stage('Push Image to Remote Repo'){
	 echo "Docker Image Tag Name ---> ihebhamdi/devops"
	     docker.withRegistry('', 'dockerHub') {
             dockerImage.push("latest")
            }
	}
   
        stage('Remove running container with old id'){
	   //remove the container which is already running, when running 1st time named container will not be available so we are usign 'True'
	   //added -a option to remove stopped container also
	  sh "docker rm -f \$(docker ps -a -f name=devops -q) || true"   
	       
    }
    stage('Remove old images') {
		// remove docker old images
		sh("docker rmi ihebhamdi/devops:latest -f")
   }

    }
}
