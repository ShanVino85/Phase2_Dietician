pipeline {
    agent any

    stages {
        stage ('Build Stage') {

            steps {
             echo "Build is in progress..."
                    bat 'mvn clean install'
              echo "Build Completed Successfully..."
            }
        }
       stage ('Testing Stage') {

            steps {
			  echo "Testing in progress"
         script 
            {
		    bat 'mvn clean test'
            }
            
            echo "Testing Completed Successfully..."
        }
       }
     	stage('Generate Cucumber report') {
		steps{
        cucumber buildStatus: 'UNSTABLE',
                reportTitle: 'My Cucuber Report',
                fileIncludePattern: '**/*.json',
		        jsonReportDirectory: 'target',
                trendsLimit: 10,
                classifications: [
                    [
                        'key': 'Browser',
                        'value': 'Chrome'
                    ]
                ]
            }
        }
        
        
         post {
    always {
      publishHTML target: [
        allowMissing: false,
        alwaysLinkToLastBuild: false,
        keepAll: true,
        reportName : 'Test Report',
        reportDir:   'target',
        reportFiles: 'Register.html'
      ]
    }
  }      
        
  
	
    }
}
