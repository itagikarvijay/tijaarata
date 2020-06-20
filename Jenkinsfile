pipeline {
    agent any
      tools {
        maven 'MAVEN363'
        jdk 'JDK8'
    }
    stages {
    	stage ("initialize") {
			steps {
				sh '''
					echo "PATH = ${PATH}"
					echo "M2_HOME = ${M2_HOME}"
				'''
			}
		}	
		stage('Checkout code') {
	        steps {
	        	echo 'CheckingOut'
	            git credentialsId: 'repoPassword', url: 'https://github.com/itagikarvijay/tijaarata.git'
	        }
    	}
        stage('build') {
            steps {
                echo 'Building'
                sh 'mvn clean install'
                 
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        stage('Deploy') {
			steps {
          		echo 'Deploying...!!!'
          		deploy adapters: [tomcat9(credentialsId: 'tomcatUPWD', path: '', url: 'http://localhost:9090')], contextPath: '/', onFailure: false, war: '**/*.war'
          	}
        }
    }
}
