import com.example.Docker

def call(String registry = '', String credentialsId) {
    return new Docker(this).dockerLogin(registry, credentialsId)
}