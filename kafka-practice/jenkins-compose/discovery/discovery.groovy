pipeline {
  agent any
  stages {
    stage('clone git lab repository') {
      steps {
        git branch: 'dev-be/discovery', credentialsId: 'gitlab', url: 'https://lab.ssafy.com/s08-final/S08P31A205.git'
      }
    }
    stage('discovery server build') {
      steps {
        script {
          try {
            echo "discovery service build"
            sh 'docker build -f server/discovery-service/Dockerfile -t nowgnas/stockey:discovery .'
          } catch (err){
            echo "error occur"
            mattermostSend(
              color: "danger",
              message: "[discovery server build fail]\n cause: ${err.cause}\n message: ${err.message}"
            )
          }
        }
      }
    }
    stage('push build images') {
      steps {
        echo 'build image'
        sh 'docker login -u nowgnas -p dltkddnjs!!'
        sh 'docker push nowgnas/stockey:discovery'
      }
    }
    stage('run discovery docker compose via ssh') {
      steps {
        script {
          try {
            echo "ssh script execute"
            sshagent (credentials: ['stockey']) {
              sh "ssh ubuntu@3.36.10.27 'bash -s' < /home/discovery-dev.sh"
            }
          } catch (err) {
            mattermostSend(
              color: "danger",
              message: "[discovery run fail]\n cause: ${err.cause}\n message: ${err.message}"
            )
          }
        }
      }
    }
  }
}