# Jenkins Shared Library

A Jenkins shared library providing reusable pipeline steps and utilities for CI/CD operations.

## Features

- **Docker Operations**: Build and push Docker images with credential management
- **Maven Operations**: Build Maven JAR files
- **Extensible Architecture**: Easy to add new pipeline steps

## Structure

```
src/
  com/
    example/
      Docker.groovy          # Docker utility class
vars/
  buildImage.groovy         # Pipeline step for building Docker images
  buildMavenJar.groovy      # Pipeline step for building Maven JARs
examples/
  Jenkinsfile               # Example usage
```

## Usage

### In Your Jenkinsfile

```groovy
@Library('jenkins-shared-library') _

pipeline {
    agent any
    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    buildImage('my-app:latest')
                }
            }
        }
    }
}
```

### Available Pipeline Steps

#### buildImage(imageName)

Builds and pushes a Docker image to the configured registry.

**Parameters:**

- `imageName` (String): The name and tag of the Docker image to build

**Example:**

```groovy
buildImage('my-application:1.0.0')
```

#### buildMavenJar()

Builds a Maven JAR file using `mvn package`.

**Example:**

```groovy
buildMavenJar()
```

## Development Setup

### VS Code Extensions

This project includes configuration for the following VS Code extensions:

- Groovy Lint, Format and Fix
- Code Groovy
- Jenkins Doc
- Groovy-Guru

### IntelliSense Support

The project includes:

- TypeScript definitions for Jenkins Pipeline steps
- Groovy linting configuration
- VS Code workspace settings optimized for Groovy development

## Configuration

### Docker Registry

Update the Docker registry URL in `src/com/example/Docker.groovy`:

```groovy
script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin YOUR_REGISTRY_URL"
```

### Credentials

Ensure the following credentials are configured in Jenkins:

- `nexus-docker-repo`: Username/password credentials for Docker registry

## Contributing

1. Follow Groovy coding conventions
2. Add appropriate documentation for new pipeline steps
3. Test your changes in a Jenkins environment
4. Update this README for new features
