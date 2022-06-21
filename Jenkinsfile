pipeline {
    agent any

    stages {
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
        step ([$class: 'CopyArtifact',
      projectName: 'phase2Dietician',
      filter: 'target/reports/*']);
      
      
      
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
