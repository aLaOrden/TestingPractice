package testingpractice

class GradesController {

    final SUBJECT_CREDITS = 6, SUBJECT_GRADE = 9, SUBJECT_NAME = 1, SUBJECT_CODE = 0, SUBJECT_TYPOLOGY = 5
    final ADVANCE_FUND = 1, ADVANCE_DISC = 2, ADVANCE_FREE = 3, ADVANCE_NIV = 5

    def planPattern = "[0-9]+ \\| [A-Za-z:\\.\\- ]+\n"
    def subjectPattern = "[0-9][A-Z\\-0-9]*[\\t][A-Za-z:\\(\\)\\.\\- ]+[\\t][0-9]+[\\t][0-9]+[\\t][0-9]+[\\t][A-Z][\\t][0-9]+[\\t][0-9]+[\\t][A-Za-z]?[\\t][0-9]\\.?[0-9]"
    def requiredPattern = "exigidos\\t[0-9]+\\t[0-9]+\\t[0-9]+\\t[0-9]+\\t[0-9\\-]+\\t[0-9]+"
    def approvedPattern = "aprobados\\t[0-9]+\\t[0-9]+\\t[0-9]+\\t[0-9]+\\t[0-9\\-]+\\t[0-9]+"
    def periodPattern = "[0-9]+[\\t]periodo academico[ ]*\\|[ ]*[0-9\\-A-Z]+"

    def index() { }

    /*
    *   Receive Academic record from the text area
    *   Return to javascript data which is split by '&&&'
    *   1. PAPA
    *   2. PA
    *   3. Period names
    *   4. subjects
    *   5. Advance components
    *   6. Advance
    *   7. Plan
    */

    def calculateAcademicRecord(){
        def academicRecord = String.valueOf( params.academicRecord )
        def codeStudyPlan = Integer.parseInt(String.valueOf(academicRecord.find(planPattern)).split('\\|')[0].trim())
        def nameStudyPlan = String.valueOf(academicRecord.find(planPattern)).trim()

        def periods = getPeriods(academicRecord)
        def advanceComponents = getAdvanceComponents(academicRecord)

        def data = getPAPA(periods) + "&&&" + getPA(periods) + "&&&" + getPeriodNames(academicRecord) + "&&&"
        data += getSubjects(periods) + "&&&" + advanceComponents + "&&&" + getAdvance(advanceComponents) + "&&&" + nameStudyPlan
        render data
    }

    def calculateProjection(){
        def input = params.inputData
        def projectedCredits = input.split("&&&")[0].split("&&")
        def projectedGrades = input.split("&&&")[1].split("&&")
        def projectedAverage = Double.parseDouble( input.split("&&&")[2] ) - 0.05
        def subjects = input.split("&&&")[3].replace("'", "").split(",")
        def gradedCredits = []
        def ungradedCredits = []
        def grades = []
        def sumGrades = 0.0
        def sumCredits = 0.0
        def sumUngradedCredits = 0.0
        projectedCredits.eachWithIndex{ it, i ->
            if( Double.parseDouble( projectedGrades[i] ) != -1 ){
                gradedCredits.add( Integer.valueOf(it) )
                grades.add( Double.parseDouble( projectedGrades[i] ) )
            }else
                ungradedCredits.add( Integer.valueOf(it) )
        }
        subjects.each{
            def subject = String.valueOf( it ).replace('\\t', '&&')
            def credits = Integer.parseInt( subject.split('&&')[SUBJECT_CREDITS] )
            def grade = Double.parseDouble( subject.split('&&')[SUBJECT_GRADE] )
            sumGrades += grade * credits
            sumCredits += credits
        }
        gradedCredits.eachWithIndex{ it, i ->
            sumGrades += grades[i] * it
            sumCredits += it
        }
        if( ungradedCredits.size() > 0 ){
            ungradedCredits.each {
                sumUngradedCredits += it
            }
            def requiredGrade = ( projectedAverage * ( sumCredits + sumUngradedCredits ) - sumGrades ) / sumUngradedCredits
            render 0 + "&&&" + requiredGrade + "&&&" + ungradedCredits.size()
        }else {
            def averageObtained = sumCredits > 0 ? sumGrades / sumCredits : 0.0
            render 1 + "&&&" + averageObtained + "&&&" + gradedCredits.size()
        }
    }

    def getAdvance = { advanceComponents ->
        if( advanceComponents.size() < 6 )
            return 0.0
        def advComp = []
        advanceComponents.each{ advComp.add( Integer.parseInt( String.valueOf(it) ) ) }
        def creditsApproved = advComp[1] + advComp[3] + advComp[5]
        def creditsRequired = advComp[0] + advComp[2] + advComp[4]
        return creditsRequired > 0 ? creditsApproved * 100.0 / creditsRequired : 0.0
    }

    def getAdvanceComponents = { academicRecord ->
        def advanceComponents = []
        def required = String.valueOf( academicRecord.find( requiredPattern ) )
        def approved = String.valueOf( academicRecord.find( approvedPattern ) )
        def positions = [ ADVANCE_FUND, ADVANCE_DISC, ADVANCE_FREE, ADVANCE_NIV ]
        positions.each{
            advanceComponents.add( Integer.parseInt( required.split('\t')[it] ) )
            advanceComponents.add( Integer.parseInt( approved.split('\t')[it] ) )
        }
        return advanceComponents
    }

    def getPAPA = { periods ->
        def papa = []
        def sumGrades = 0.0
        def sumCredits = 0.0
        periods.each{
            def periodsText = String.valueOf( it )
            while( periodsText.find( subjectPattern ) ){
                def subject = String.valueOf( periodsText.find( subjectPattern ) )
                def credits = Integer.parseInt( subject.split('\t')[SUBJECT_CREDITS] )
                def grade = Double.parseDouble( subject.split('\t')[SUBJECT_GRADE] )
                sumGrades += grade * credits
                sumCredits += credits
                periodsText = periodsText.replace( subject, "" )
            }
            papa.add( sumCredits > 0 ? sumGrades / sumCredits : 0.0 )
        }
        println("PAPA: " + papa)
        return papa
    }

    def getSumCredits = { periods ->
        def sumCredits = 0.0
        periods.each{
            def periodsText = String.valueOf( it )
            while( periodsText.find( subjectPattern ) ){
                def subject = String.valueOf( periodsText.find( subjectPattern ) )
                def credits = Integer.parseInt( subject.split('\t')[SUBJECT_CREDITS] )
                def grade = Double.parseDouble( subject.split('\t')[SUBJECT_GRADE] )
                if( grade >= 3 )
                    sumCredits += credits
                periodsText = periodsText.replace( subject, "" )
            }
        }
        return sumCredits
    }

    def getPA = { periods ->
        def pa = []
        def subjects = []
        def duplicatedSubject
        periods.eachWithIndex{ period, i ->
            def periodsText = String.valueOf( period )
            while( periodsText.find( subjectPattern ) ){
                def subjectText = String.valueOf( periodsText.find( subjectPattern ) )
                subjects.add( subjectText )
                periodsText = periodsText.replace( subjectText, "" )
            }
            def subjectsPA = []
            subjects.eachWithIndex{ subject, j ->
                subject = String.valueOf( subject )
                duplicatedSubject = false
                def code1 = Integer.parseInt( ( subject.split('\t')[SUBJECT_CODE] )[0..(subject.indexOf('-')-1)] )
                def grade1 = Double.parseDouble( subject.split('\t')[SUBJECT_GRADE] )
                subjects.eachWithIndex{ subject2, k ->
                    subject2 = String.valueOf( subject2 )
                    if( j != k ){
                        def code2 = Integer.parseInt( ( subject2.split('\t')[SUBJECT_CODE] )[0..(subject2.indexOf('-')-1)] )
                        if( code1 == code2 ) {
                            duplicatedSubject = true
                            def grade2 = Double.parseDouble( subject2.split('\t')[SUBJECT_GRADE] )
                            if( grade2 >= grade1 ) {
                                if( !subjectsPA.contains( subject2 ) )
                                    subjectsPA.add( subject2 )
                                if( subjectsPA.contains( subject ) )
                                    subjectsPA.remove( subject )
                            }
                            else {
                                if( !subjectsPA.contains( subject ) )
                                    subjectsPA.add( subject )
                                if( subjectsPA.contains( subject2 ) )
                                    subjectsPA.remove( subject2 )
                            }
                        }
                    }
                }
                if(!duplicatedSubject)
                    subjectsPA.add( subject )
            }
            def sumGrades = 0.0;
            def sumCredits = 0.0;
            subjectsPA.each{
                def grade = Double.parseDouble( it.split('\t')[SUBJECT_GRADE] )
                def credits = Integer.parseInt( it.split('\t')[SUBJECT_CREDITS] )
                sumGrades += grade * credits
                sumCredits += credits
            }
            pa.add( sumCredits > 0 ? sumGrades / sumCredits : 0.0 )
        }
        println("PA: " + pa)
        return pa
    }

    def getPeriods = { academicRecord ->
        def periods = []
        def recordSoFar = academicRecord
        try {
            def periodName = recordSoFar.find(periodPattern)
            recordSoFar = recordSoFar.substring(recordSoFar.indexOf(periodName)).replace(periodName, "")
            while (recordSoFar.find(periodPattern)) {
                periodName = recordSoFar.find(periodPattern)
                periods.add(recordSoFar.substring(0, recordSoFar.indexOf(periodName)))
                recordSoFar = recordSoFar.substring(recordSoFar.indexOf(periodName)).replace(periodName, "")
            }
            periods.add(recordSoFar)
        }catch(Exception e){
            e.printStackTrace()
            throw e
        }
        return periods
    }

    def getPeriodNames = { academicRecord ->
        def periodNames = []
        def recordSoFar = academicRecord
        try {
            while (recordSoFar.find(periodPattern)) {
                def periodName = recordSoFar.find(periodPattern)
                periodNames.add(periodName.split("\\|")[1])
                recordSoFar = recordSoFar.substring(recordSoFar.indexOf(periodName)).replace(periodName, "")
            }
        }catch(Exception e){
            e.printStackTrace()
            throw e
        }
        return periodNames
    }

    def getSubjects = { periods ->
        def subjects = []
        periods.each{
            def periodsText = String.valueOf( it )
            while( periodsText.find( subjectPattern ) ){
                def subject = String.valueOf( periodsText.find( subjectPattern ) )
                subjects.add( subject )
                periodsText = periodsText.replace( subject, "" )
            }
        }
        return subjects
    }
}
