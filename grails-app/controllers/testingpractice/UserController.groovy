package testingpractice

class UserController {

    def index() { }

    def getGradesCount(User user){
        return user.getSubjects().size()
    }

    def getGradesAverages(User user){
        def sumGrades = 0
        user.subjects.each {
            sumGrades += it.grade
        }
        return sumGrades / user.subjects.size()
    }
}
