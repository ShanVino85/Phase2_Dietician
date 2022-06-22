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
        
        stage('publish HTML reports') {
        steps {
            unstash 'source'

            script {
                sh 'ls target/ > listFiles.txt'
                def files = readFile("listFiles.txt").split("\\r?\\n");
                sh 'rm -f listFiles.txt'

                for (i = 0; i < files.size(); i++) {
                    publishHTML target: [
                        allowMissing:false,
                        alwaysLinkToLastBuild: false,
                        keepAll:true,
                        reportDir: 'target/' + files[i],
                        reportFiles: 'index.html',
                        reportName: files[i]
                    ]
                }                   
            }           
        }
    }
	    
	
    }
}
