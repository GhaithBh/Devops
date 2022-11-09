pipeline {
    agent any

    stages {
        
                stage('git') {
            steps {
            
                git branch: 'Iheb', url: 'https://github.com/GhaithBh/Devops.git',
                credentialsId:"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";
                
            }
}
        
       stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """
            }
        }
        
      stage("MVN Compile"){
            steps {
                sh """mvn compile -e """
                
            }
        }
      stage("SONARQUBE"){
            steps {
                sh """mvn sonar:sonar """
                
            }
        }
        stage("Junit/Mockito"){
            steps {
                sh """mvn test """
                
            }
        }
        stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        }
           stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }
        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """
                
            }
        }

    }
}
