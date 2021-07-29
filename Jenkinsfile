pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building the application 1'
            }
        }
        stage('test') {
            steps {
                bat """
                katalonc -noSplash -runMode=console -projectPath="C:\Users\ACER\Downloads\KatalonSealor\KatalonGitProject\Web Saleor.prj" -retry=0 -testSuitePath="Test Suites/Login" -executionProfile="default" -browserType="Firefox" --config -proxy.auth.option=NO_PROXY -proxy.system.option=NO_PROXY -proxy.system.applyToDesiredCapabilities=true
                """
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application 2'
            }
        }
    }
}