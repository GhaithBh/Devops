node {
    try{
   
        stage('checkout GIT'){
            echo 'Pulling';
            git branch: 'fatima',
            url : 'https://github.com/GaithBh/Devops',
            credentialsId: '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'
                
        }
        stage(' compiling '){
            
            sh """mvn compile"""
        }
        stage(' packaging '){
            
            sh  """mvn package"""
        }
        stage(' Sonarqube scan'){
            sh  """mvn sonar:sonar -Dsonar.login=a3b0ece5ce9ed145307202b25877e362e8652716 -Dsonar.host.url=http://192.168.56.101:9000"""

        }
        
        stage('Junit/Mokito'){
            sh """mvn test"""
            
        }
        
       
        stage('Nexus'){
            nexusPublisher nexusInstanceId: "Nexus" , nexusRepositoryId: 'Devops', packages: [[$class: 'MavenPackage', mavenAssetList: 
            [classifier: '', extension: '', filepath: './target/achat-api.jar' ]],mavenCoordinate: [artifactId: 'achat', groupId: 
            'tn.esprit.rh', packaging: 'jar', version: '1']]]
            
        }
        
         stage('Docker'){
            
        }
    }  
    catch(e) {
        def to = "fatimetou.cheikhneda@esprit.tn"
        currentBuilder.result = 'FAILURE'
        def subject = "Jenkins - Build Failure"
        def content = '${JELLY_SCRIPT, template="html"}'
        emailext(body: content, mimeType: 'text/html',
                replyTp: '$DEFAULT_REPLYTO', subject: subject,
                to: to)
    }
        
}
