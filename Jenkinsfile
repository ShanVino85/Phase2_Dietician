pipeline {
    agent any
    
      stages {
      
       stage ('Check Out')
       {
        steps {
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ShanVino85/Phase2_Dietician.git']]])
        }
       }
       stage ('Build Stage') {
            steps {
             echo "Build is in progress..."
                    bat 'mvn clean'
            }
        }
        stage ('Testing Stage') {

            steps {
			  echo "Testing in progress"
                    bat 'mvn test'
            }
        }
        stage ('Cucumber reports') {
        	      		  steps {
                           cucumber buildStatus: "UNSTABLE", 
                           fileIncludePattern: "**/*.json",
                           jsonReportDirectory: 'target/reports'
                           }
        }	
    }
}
