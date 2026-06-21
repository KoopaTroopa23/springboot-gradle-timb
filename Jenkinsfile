pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Build & Test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
            post {
                always {
                    junit testResults: 'build/test-results/test/*.xml', allowEmptyResults: true
                    archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
                }
            }
        }

        stage('Boot Run Smoke Test') {
            steps {
                sh '''
                    ./gradlew bootRun > bootrun.log 2>&1 &
                    echo $! > bootrun.pid

                    for i in $(seq 1 30); do
                      if curl -sf http://localhost:8080/ > /dev/null 2>&1; then
                        echo "Application is up on attempt $i"
                        break
                      fi
                      echo "Attempt $i/30: not ready yet, sleeping 5s..."
                      sleep 5
                      if [ "$i" -eq 30 ]; then
                        echo "Application did not start within 150s. Boot log:"
                        cat bootrun.log
                        exit 1
                      fi
                    done

                    STATUS=$(curl -s -o /dev/null -w "%{http_code}" -X POST "http://localhost:8080/api/notes?content=jenkins-smoketest")
                    echo "POST /api/notes -> HTTP $STATUS"
                    [ "$STATUS" = "200" ] || { echo "FAIL: expected 200, got $STATUS"; exit 1; }

                    BODY=$(curl -s http://localhost:8080/api/notes)
                    echo "GET /api/notes -> $BODY"
                    echo "$BODY" | grep -q "jenkins-smoketest" || { echo "FAIL: note not found in response"; exit 1; }
                '''
            }
            post {
                always {
                    sh 'kill $(cat bootrun.pid) 2>/dev/null || true'
                }
                failure {
                    archiveArtifacts artifacts: 'bootrun.log', allowEmptyArchive: true
                }
            }
        }
    }
}
