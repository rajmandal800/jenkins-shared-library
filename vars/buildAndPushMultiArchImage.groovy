#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName, String platforms = 'linux/amd64,linux/arm64'){
    return new Docker(this).dockerBuildMultiArchAndPush(imageName,platforms)
}