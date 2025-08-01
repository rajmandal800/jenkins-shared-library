def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        // sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'
        // sh "echo $PASS | docker login -u $USER --password-stdin"
        // sh 'docker push nanajanashia/demo-app:jma-2.0'

        sh "docker build -t ${imageName} ."
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.64.8:8083"
        sh "docker push ${imageName}"
    }
} 