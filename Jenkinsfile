pipeline {
    agent any 
    stages {
        stage('---package---') { 
            steps {
                sh "mvn package" 
            }
        }
        stage('deployment project') { 
            steps {
                sh "java -jar ./target/yoda-master-jedi-1.0-SNAPSHOT.jar"  
            }
        }
    }
}
