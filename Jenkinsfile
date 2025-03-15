pipeline {
    agent any
  environment {
    MAVEN_ARGS=" -e clean install"
    registry = ""
    dockerContainerName = 'bookapi'
    dockerImageName = 'bookapi-api'
  }
  stages {
    stage('Build') {
       steps {
         withMaven(maven : 'apache-maven-3.9.9') {
                     sh "mvn ${MAVEN_ARGS}"
                 }
       }
    }

    stage('Initialize'){
    steps{
    script{
            def dockerHome = tool 'docker'
            env.PATH = "${dockerHome}/bin:${env.PATH}"
            }
        }
        }

 stage('clean container') {

      steps {
       sh 'docker ps -f name=${dockerContainerName} -q | xargs --no-run-if-empty docker container stop'
       sh 'docker container ls -a -fname=${dockerContainerName} -q | xargs -r docker container rm'
       sh 'docker images -q --filter=reference=${dockerImageName} | xargs --no-run-if-empty docker rmi -f'
      }
    }
  stage('docker-compose start') {
      steps {
      script{
       sh 'docker-compose up -d'
       }
      }
    }
    stage ('start app'){
    steps{
    withMaven(maven : 'apache-maven-3.9.9'){
    sh 'mvn  spring-boot:run'
    }
    }
    }
  }
}