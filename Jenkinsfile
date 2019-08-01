pipeline {
  agent any {
    stage('---package---') {
      sh "mvn package"
    }
    stage('deployment project'){
      sh "java -jar ./target/yoda-master-jedi-1.0-SNAPSHOT.jar"
    }
  }
}
