def deployOnLAMBDA () {
    echo "Hello ${name}"
}
node {
    stage('Hello') {
        Greet('NaiveSkill')
    }
}
