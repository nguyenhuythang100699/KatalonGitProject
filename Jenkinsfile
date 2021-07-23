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
                cd C:\\Users\\ACER\\Downloads\\Katalon_Studio_Engine_Windows_64-8.0.5
                katalonc -noSplash -runMode=console -projectPath="C:\\Users\\ACER\\Downloads\\KatalonSealor\\KatalonGitProject\\Web Saleor.prj" -retry=0 -testSuitePath="Test Suites/Login" -executionProfile="default" -browserType="Chrome" -apiKey="bd4e031b-2109-4190-9ed2-12b27ca6cebc" --config -proxy.auth.option=NO_PROXY -proxy.system.option=NO_PROXY -proxy.system.applyToDesiredCapabilities=true
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