#!/usr/bin/env groovy

/**
 * Jenkins Pipeline step to build and push Docker images
 * 
 * @param imageName The name of the Docker image to build and push
 * @return Result of the Docker build operation
 * 
 * Example usage:
 * buildImage('my-app:latest')
 */
def call(String imageName) {
    return new com.example.Docker(this).buildImage(imageName)
}