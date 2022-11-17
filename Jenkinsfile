pipeline {
    agent any
    
  

	environment {
        registry = "ademng/achat"
        registryCredential = 'docker-cred'
        dockerImage = ''
    }
    stages {
        
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
          
        stage('Checkout Git') {
            steps {
                echo 'pulling...';
                git branch: 'master',
                url:'https://github.com/ademNG/Devopstest.git';
            }
        }  
         stage('MVN CLEAN') {
            steps {
                sh 'mvn clean install'
        }
    }
         stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
        }
    }
    
    stage ("Launching unit tests"){
			steps{
			    echo 'Testing..'
				sh "mvn test"
			}
			
		}
		
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=adem1234 -DskipTests'
        }
    }
    stage ("Deployement"){
			steps{
			    echo 'Deploying to Nexus'
				sh """mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.16:8081//repository/maven-releases/ -Dfile=target/achat-1.0.jar"""
			}
		}
		     stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
      stage('Deploy our image') {
               	steps {
                   	script {
                       	docker.withRegistry('', registryCredential) {
                          	dockerImage.push()
                 		}
                	}
            	}    
		}
    
        stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d "
          }
        }
       
      stage('Cleaning up') {

                steps {

                    sh "docker rmi $registry:$BUILD_NUMBER"

            }

        }
	  
   
}
    post {
            always{
                archiveArtifacts artifacts: '*.*', onlyIfSuccessful: true
                
                emailext to: "adem.naitgaied@esprit.tn",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
                attachmentsPattern: '*.*'
                
            cleanWs()
            }
              
          }
}
