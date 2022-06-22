pipeline {
    agent any

    stages {
        stage ('Build Stage') {

            steps {
             echo "Build is in progress..."
                    bat 'mvn clean install'
            }
        }
       stage ('Testing Stage') {

            steps {
			  echo "Testing in progress"
         script 
            {sh "mvn clean test -Dcucumber.options=\"src/test/resources/Features/ --tags @YourTagName\""}
            }
        }
        
     	stage('Generate HTML report') {
		steps{
        cucumber buildStatus: 'UNSTABLE',
                reportTitle: 'MyReport',
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
	    
	
    }
}
