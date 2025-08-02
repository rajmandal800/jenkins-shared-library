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
    
   
    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin 192.168.64.8:8083"
        }
    }

    def dockerBuild(String imageName) {
        script.sh "docker build -t ${imageName} ."
    }

    def dockerPush(String imageName) {
        script.sh "docker push ${imageName}"
    }
}