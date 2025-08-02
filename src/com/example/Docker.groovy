#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    /** Jenkins pipeline script context */
    def script
    
    /**
     * Constructor
     * @param script Jenkins pipeline script context
     */
    Docker(script) {
        this.script = script
    }
    
    /**
     * Build and push Docker image
     * @param imageName Name of the Docker image to build
     * @return void
     */
    def buildImage(String imageName) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t ${imageName} ."
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin 192.168.64.8:8083"
            script.sh "docker push ${imageName}"
        }
    }
}