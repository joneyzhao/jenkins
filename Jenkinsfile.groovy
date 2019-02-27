pipeline {
    agent any
    stages {
	stage('Build1') {
            steps {
                echo 'java version'
                bat 'java -version || true'   
            }
        }
	stage('Build2') {
            steps {
                echo 'npm-install'
                bat 'npm install'    
            }
        }
        stage('Build3') {
            steps {
                echo 'building'
                bat 'node build/build.js'    
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                bat 'npm run unit && npm run e2e'
            }
        }
        stage('lint') {
            steps {
                echo 'lintCode'
                bat 'eslint --ext .js,.vue src test/unit test/e2e/specs'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}


// "test": "npm run unit && npm run e2e",

// "lint": "eslint --ext .js,.vue src test/unit test/e2e/specs",

// "build": "node build/build.js"