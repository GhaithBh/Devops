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
        stage('DB UP') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
            }
        }
        stage('MAVEN CHECK') {
            steps{
                sh 'mvn clean'
                sh 'mvn  package'
            }

        }
        stage ('MOCK TEST') {
            steps{
                sh 'mvn  test'
            }
        }
        stage ('SonarQube SCAN') {
            steps{
                sh '''
                mvn sonar:sonar
                '''
            }
        }
        stage('DEPLOY -> Nexus'){
            steps{
                sh """mvn deploy """
            }
        }
         stage('BUILD IMAGE')
        {
            steps {
                 sh 'docker build --build-arg IP=0.0.0.0 -t ihebhamdi/devops  .'
            }
        }
        stage('AUTH')
        {
            steps {
                sh 'echo $dockerhub_PSW | docker login -u ihebhamdi -p dckr_pat_9YAJAIlUg1TpVlKFUAf3f48oLEI'
            }    
       
        }
      stage('PUSH') {

			steps {
				sh 'docker push ihebhamdi/devops'
			}
		}
        
       stage('START') {
              steps {
                  sh "docker-compose -f docker-compose.yml up -d  "
              }
              }
        stage('NOTIFY'){
           steps {
            mail bcc: '', body: '''Hello from Jenkins,
            Devops Pipeline returned success.
            Best Regards''', cc: '', from: '', replyTo: '', subject: 'Devops Pipeline', to: 'iheb.hamdi.1@esprit.tn'
            }
       }

    }
}
