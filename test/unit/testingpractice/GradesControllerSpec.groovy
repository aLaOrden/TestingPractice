package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(GradesController)
class GradesControllerSpec extends Specification {

    def academicRecord = "\n" +
            "SELECCIONE EL ROL DE USUARIO\n" +
            "estudiante\n" +
            "Ld Erick Stevens Velasco Amaya terminar sesion\n" +
            "navegacion estudiante\n" +
            "inicio\n" +
            "apoyo academico\n" +
            "archivo\n" +
            "certificados\n" +
            "mi historia academica\n" +
            "mis datos personales\n" +
            "catalogo prog. curriculares\n" +
            "documentacion\n" +
            "informacion financiera\n" +
            "libre acceso\n" +
            "zona de busquedas\n" +
            " \n" +
            "inicio > archivo > mi historia academica\n" +
            "MI HISTORIA ACADEMICA/\n" +
            "version impresion+ preguntas frecuentes+ descarga de archivos\n" +
            "\t\t\t\n" +
            "2879 | ingenieria de sistemas y computacion \n" +
            "estudiantes que deben nivelar dos asignaturas [3]\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t2543 | ingenieria de sistemas\n" +
            "\n" +
            "  01\tperiodo academico | 2011-II\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "1000001-21\tMATEMATICAS BASICAS\t4\t8\t12\tP\t4\t1\t\t3.7\n" +
            "aprobado\n" +
            "1000002-33C\tLECTO-ESCRITURA\t4\t7\t11\tP\t4\t1\t\t4.5\n" +
            "aprobado\n" +
            "2015734-33C\tPROGRAMACION DE COMPUTADORES\t6\t0\t6\tC\t3\t1\t\t4.4\n" +
            "aprobado\n" +
            "2016749-33C\tINTRODUCCION A LA INGENIERIA DE SISTEMAS\t4\t0\t4\tC\t3\t1\t\t4.5\n" +
            "aprobado\n" +
            "4-0\tRECONOCIMIENTO IDIOMA NIVEL I - II - III\t0\t0\t0\tP\t9\t1\tF\tAP\n" +
            "  02\tperiodo academico | 2012-I\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "no aprobado\n" +
            "1000004-1\tCALCULO DIFERENCIAL\t4\t0\t4\tB\t4\t1\t\t2.2\n" +
            "aprobado\n" +
            "2016350-33C\tMATEMATICAS DISCRETAS\t4\t0\t4\tB\t4\t1\t\t3.5\n" +
            "aprobado\n" +
            "2016375-33C\tPROGRAMACION ORIENTADA A OBJETOS\t4\t0\t4\tC\t3\t1\t\t3.6\n" +
            "  03\tperiodo academico | 2012-II\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "1000004-33C\tCALCULO DIFERENCIAL\t4\t0\t4\tB\t4\t2\t\t3.7\n" +
            "aprobado\n" +
            "2016698-33C\tELEMENTOS DE COMPUTADORES\t4\t0\t4\tC\t3\t1\t\t5.0\n" +
            "aprobado\n" +
            "2016699-33C\tESTRUCTURAS DE DATOS\t4\t0\t4\tC\t3\t1\t\t3.1\n" +
            "aprobado\n" +
            "2021152-33C\tCUANTICA PARA TODOS Y PARA TODO\t3\t0\t3\tL\t3\t1\t\t4.5\n" +
            "  04\tperiodo academico | 2013-I\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "no aprobado\n" +
            "1000005-33C\tCALCULO INTEGRAL\t4\t0\t4\tB\t4\t1\t\t1.9\n" +
            "no aprobado\n" +
            "1000019-33C\tFUNDAMENTOS DE MECANICA\t6\t0\t6\tB\t4\t1\t\t2.7\n" +
            "aprobado\n" +
            "2016353-33C\tBASES DE DATOS\t4\t0\t4\tC\t3\t1\t\t3.8\n" +
            "aprobado\n" +
            "2016697-33C\tARQUITECTURA DE COMPUTADORES\t4\t0\t4\tC\t3\t1\t\t4.3\n" +
            "  05\tperiodo academico | 2013-II\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "1000005-16\tCALCULO INTEGRAL\t4\t0\t4\tB\t4\t2\t\t3.5\n" +
            "aprobado\n" +
            "1000019-14\tFUNDAMENTOS DE MECANICA\t6\t0\t6\tB\t4\t2\t\t3.4\n" +
            "aprobado\n" +
            "1000013-22\tPROBABILIDAD Y ESTADISTICA FUNDAMENTAL\t4\t0\t4\tB\t3\t1\t\t3.7\n" +
            "aprobado\n" +
            "2016707-1\tSISTEMAS OPERATIVOS\t4\t0\t4\tC\t3\t1\t\t4.2\n" +
            "  06\tperiodo academico | 2014-I\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "1000003-4\tALGEBRA LINEAL\t4\t0\t4\tB\t4\t1\t\t3.7\n" +
            "aprobado\n" +
            "2015174-2\tINTRODUCCION A LA TEORIA DE LA COMPUTACION\t4\t0\t4\tB\t4\t1\t\t4.6\n" +
            "no aprobado\n" +
            "1000017-11\tFUNDAMENTOS DE ELECTRICIDAD Y MAGNETISMO\t6\t0\t6\tB\t4\t1\t\t2.9\n" +
            "aprobado\n" +
            "2025964-1\tMATEMATICAS DISCRETAS II\t4\t0\t4\tB\t4\t1\t\t4.5\n" +
            "  07\tperiodo academico | 2014-II\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "no aprobado\n" +
            "1000006-7\tCALCULO EN VARIAS VARIABLES\t4\t0\t4\tB\t4\t1\t\t2.5\n" +
            "aprobado\n" +
            "1000047-9\tINGLES IV- SEMESTRAL\t4\t4\t8\tP\t3\t1\t\tAP\n" +
            "aprobado\n" +
            "1000017-13\tFUNDAMENTOS DE ELECTRICIDAD Y MAGNETISMO\t6\t0\t6\tB\t4\t2\t\t3.5\n" +
            "aprobado\n" +
            "2016701-2\tINGENIERIA DE SOFTWARE I\t4\t0\t4\tC\t3\t1\t\t4.2\n" +
            "  08\tperiodo academico | 2015-I\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "1000006-16\tCALCULO EN VARIAS VARIABLES\t4\t0\t4\tB\t4\t2\t\t3.2\n" +
            "aprobado\n" +
            "2016696-2\tALGORITMOS\t4\t0\t4\tB\t3\t1\t\t3.5\n" +
            "aprobado\n" +
            "2025967-2\tREDES DE COMPUTADORES\t4\t0\t4\tC\t3\t1\t\t3.7\n" +
            "  09\tperiodo academico | 2015-II\t\t\n" +
            "codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.\n" +
            "aprobado\n" +
            "2015703-13\tINGENIERIA ECONOMICA\t4\t0\t4\tB\t3\t1\t\t5.0\n" +
            "aprobado\n" +
            "2016722-1\tCOMPUTACION PARALELA Y DISTRIBUIDA\t4\t0\t4\tC\t3\t1\t\t4.0\n" +
            "aprobado\n" +
            "2025970-2\tMODELOS Y SIMULACION\t4\t0\t4\tC\t3\t1\t\t3.9\n" +
            "aprobado\n" +
            "2025994-2\tTEORIA DE LA INFORMACION Y SISTEMAS DE COMUNICACION\t4\t0\t4\tC\t3\t1\t\t4.7\n" +
            " \t\t\n" +
            "Promedio Academico\t[4.0]\n" +
            "Promedio Aritmetico Ponderado Acumulado - PAPA\t[3.7]\n" +
            "\t\n" +
            "52.7%\n" +
            "% de avance en los creditos exigidos del plan de estudios\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\n" +
            "\t\t\t\t\t\t\t\t\t\t\n" +
            "creditos\tplan de estudios\tnivel\ttotal estudiante\t\n" +
            "fundam.\tdiscipl.\tlibre e.\ttotal  \n" +
            "exigidos\t51\t81\t33\t165\t20\t185\t\n" +
            "aprobados\t45\t39\t3\t87\t20\t107\t\n" +
            "aprobados plan\t45\t39\t3\t87\t--\t87\t\n" +
            "pendientes\t6\t42\t30\t78\t0\t78\t\n" +
            "inscritos\t76\t39\t9\t124\t11\t135\t\n" +
            "Creditos excedentes\tFundamentacion\t0\tDisciplinar-Profesional\t0\tTotal creditos excedentes\t0\t\n" +
            "Total de creditos cancelados en los periodos cursados\t17\t\n" +
            "resumen de creditos\t\n" +
            "Cupo adicional de creditos\t80\t\n" +
            "Cupo creditos\t121\t\n" +
            "cupo de creditos menos creditos pendientes\t43\t\n" +
            "\n" +
            " \n" +
            "version impresion\n" +
            "\n" +
            "inicio | comentarios y sugerencias | preguntas frecuentes | descarga de archivos | mapa del sitio | noticias | terminos de uso \n" +
            "Sistema de Informacion Academica [Nivel Nacional]\n" +
            "Ciudad Universitaria, Cra 30 # 45-03 - Edificio 103 Polideportivo 2 Piso, Bogota - Colombia | www.registro.unal.edu.co | divregistro_bog@unal.edu.co\n" +
            "Actualizado: 1 de Febrero de 2016 | Todos los derechos reservados ©Universidad Nacional de Colombia 2016"

    def setup() {
    }

    def cleanup() {
    }

    def "testing periods size"() {
        when:
        def periods = controller.getPeriods(academicRecord)
        def periodsSize = periods.size()
        then:"size of periods"
        periodsSize == 9
    }

    def "testing periods name"() {
        when:
        def periodNames = controller.getPeriodNames(academicRecord)
        then:"last item of periods"
        periodNames[3].toString().trim().equals("2015-II")
    }

    def "getPeriods accepts null values"() {
        when:
        controller.getPeriods("")

        then:
        thrown Exception
    }
    def "get subjects size"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)

        when: "The users attempts to get the subjects"
        def subjects = controller.getSubjects(periods)

        then: "The subjects size is..."
        subjects.size() == 42
    }
    def "get subjects PAPA"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)
        def PAPA = controller.getPAPA(periods)

        expect:
        PAPA[a] == c

        where: "The PAPA in each period is..."
        a << [0, 1, 2, 3, 4, 5, 6, 7, 8]
        c << [4.25, 3.7239999999999998, 3.8342105263157893, 3.623076923076923, 3.631818181818182, 3.6890243902439024, 3.646236559139785, 3.62621359223301, 3.706956521739131]
    }

    @Unroll
    def "get subjects PA for period #a is #c"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)
        def PAPA = controller.getPA(periods)

        expect:
        PAPA[a] == c

        where: "The PA in each period is..."
        a || c
        0 || 4.25
        1 || 3.7239999999999998
        2 || 4.026470588235293
        3 || 3.7416666666666667
        4 || 3.9351851851851847
        5 || 3.932857142857143
        6 || 3.9000000000000004
        7 || 3.912048192771085
        8 || 3.9736842105263164
    }

    def "get progress"(){
        given: "An academic record"
       def components = controller.getAdvanceComponents(academicRecord)

        expect:
        components[a] == c

        where: "The progress in each component is..."
        a || c
        0 || 51
        1 || 51
        2 || 81
        3 || 49
        4 || 33
        5 || 34
        6 || 16
        7 || 12
    }

    def "get sum of credits"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)
        def sum = controller.getSumCredits(periods)

        expect:
        sum == (95 as BigDecimal)
    }

    @Unroll
    def "calculates the academic record"(){
        given: "the academic record"
        def record = controller.calculateAcadRecord(academicRecord)

        expect:
        record[i] == rec

        where: "the positions are..."
        i << [0, 1, 2]
        rec << [4.25, 3.7239999999999998, 3.8342105263157893]
    }
}

