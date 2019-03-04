pipeline {
    agent any
    stages {
	    stage('install') {
            steps {
                echo 'install...'
                sh 'npm install --verbose'
            }
        }
        stage('Build') {
            steps {
                echo 'building'
                sh 'node build/build.js'    
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                sh 'npm run unit && npm run e2e'
            }
        }
        stage('lint') {
           steps {
               echo 'lintCode'
               sh 'npm run lint'
           }
       }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'npm run deploy &'    
            }
        }
    }
}

// sh 'cd ${dist} && http-server -p 8890'

// def dist = 'C:/Users/赵欢欢/Desktop/jenkins练习/jenkins/dist>'

// "test": "npm run unit && npm run e2e",

// "lint": "eslint --ext .js,.vue src test/unit test/e2e/specs",

// "build": "node build/build.js"