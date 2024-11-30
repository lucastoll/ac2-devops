pipeline {
  agent any
  environment {
    PATH = "${env.PATH}:/usr/local/bin"
  }
  stages {
    stage("verify tooling") {
      steps {
        sh '''
          docker version
          docker info
          docker compose version 
          curl --version
        '''
      }
    }
    stage('Prune Docker data') {
      steps {
        sh 'docker system prune -a --volumes -f'
      }
    }
    stage('Start container') {
      steps {
        sh 'docker-compose -f docker-compose.prod.yml -p pipeline-prod up -d --no-color --wait'
      }
    }
    stage('Wait for server to start') {
      steps {
        script {
          sleep 15
        }
      }
    }
    stage('Run tests against the container') {
      steps {
        sh 'curl http://localhost:8585/api/alunos'
      }
    }
  }
}