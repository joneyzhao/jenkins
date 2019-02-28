pipeline {
    agent any
    stages {
	    // stage('��װ����') {
        //     steps {
        //         echo 'npm-install'
        //         bat 'npm install --verbose'
        //     }
        // }
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
                sh 'eslint --ext .js,.vue src test/unit test/e2e/specs'
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