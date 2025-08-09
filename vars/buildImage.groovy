#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName,  String platform = 'linux/amd64') {
    return new Docker(this).dockerBuild(imageName,platform)
}