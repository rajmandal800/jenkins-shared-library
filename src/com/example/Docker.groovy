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
    


    def dockerLogin(String registry = '', String credentialsId) {
    script.withCredentials([script.usernamePassword(credentialsId: credentialsId, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        def loginTarget = registry?.trim() ? registry : ''
        script.sh "echo \$PASS | docker login -u \$USER --password-stdin ${loginTarget}"
    }
}

  def dockerBuild(String imageName) {
    script.sh "docker buildx build --platform linux/amd64,linux/arm64 -t ${imageName} ."
}
    def dockerPush(String imageName) {
        script.sh "docker push ${imageName}"
    }
}