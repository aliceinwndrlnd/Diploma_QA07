pipeline {
    agent any

    tools {
        maven "M3"
        jdk 'Java 11'
    }

    stages {
        stage('Test run') {
            steps {
                bat 'mvn clean test -Dsuite=src/test/resources/RegressionTests_Kufar'
                bat 'mvn clean test -Dsuite=src/test/resources/SmokeTest_Kufar'
            }
        }
        stage('Reports') {
                steps {
                    script {
                        allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])}
                   }
           }
    }
}