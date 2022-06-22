pipeline {
    agent any

    stages {
        stage ('Build Stage') {

            steps {
             echo "Build is in progress..."
                    bat 'mvn clean install'
            }
        }
      /*  stage ('Testing Stage') {

            steps {
			  echo "Testing in progress"
                    bat 'mvn test'
            }
        }*/
        
     	stage('Generate HTML report') {
		steps{
        cucumber buildStatus: 'UNSTABLE',
                reportTitle: 'My report',
                fileIncludePattern: '**/*.json',
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
