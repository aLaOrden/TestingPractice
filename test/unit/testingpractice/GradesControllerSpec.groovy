package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(GradesController)
class GradesControllerSpec extends Specification {

    def academicRecord = """SELECCIONE EL ROL DE USUARIO
estudiante
Miguel Angel Asencio Hurtado terminar sesion
navegacion estudiante
inicio
apoyo academico
archivo
certificados
mi historia academica
mis datos personales
catalogo prog. curriculares
documentacion
informacion financiera
libre acceso
zona de busquedas

inicio > archivo > mi historia academica
MI HISTORIA ACADEMICA/
version impresion+ preguntas frecuentes+ descarga de archivos
\t\t\t
2879 | ingenieria de sistemas y computacion
estudiantes que deben nivelar una asignatura [2]



\t2545 | ingenieria electronica

  01\tperiodo academico | 2014-I\t\t
codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.
aprobado
1000003-0\tALGEBRA LINEAL\t4\t0\t4\tB\t4\t1\t\t4.0
aprobado
1000004-0\tCALCULO DIFERENCIAL\t4\t0\t4\tB\t4\t1\t\t4.0
aprobado
1000005-0\tCALCULO INTEGRAL\t4\t0\t4\tB\t4\t1\t\t3.7
aprobado
1000006-0\tCALCULO EN VARIAS VARIABLES\t4\t0\t4\tB\t4\t1\t\t3.4
aprobado
1000007-0\tECUACIONES DIFERENCIALES\t4\t0\t4\tB\t4\t1\t\t3.3
aprobado
2015159-0\tVARIABLE COMPLEJA\t4\t0\t4\tL\t4\t1\t\t3.3
aprobado
1000017-0\tFUNDAMENTOS DE ELECTRICIDAD Y MAGNETISMO\t6\t0\t6\tB\t4\t1\t\t3.0
aprobado
1000019-0\tFUNDAMENTOS DE MECANICA\t6\t0\t6\tB\t4\t1\t\t3.4
aprobado
1000013-0\tPROBABILIDAD Y ESTADISTICA FUNDAMENTAL\t4\t0\t4\tB\t3\t1\t\t3.0
aprobado
1000040-0\tINTRODUCCIoN A LA CIENCIA DE MATERIALES\t4\t0\t4\tL\t3\t1\t\t3.9
aprobado
2015702-0\tGERENCIA Y GESTIoN DE PROYECTOS\t4\t0\t4\tB\t3\t1\t\t4.0
aprobado
2015703-0\tINGENIERIA ECONoMICA\t4\t0\t4\tB\t3\t1\t\t3.3
aprobado
2015712-0\tDISENO DE PLANTAS Y EQUIPOS\t4\t0\t4\tL\t3\t1\t\t3.0
aprobado
2015734-0\tPROGRAMACIoN DE COMPUTADORES\t6\t0\t6\tC\t3\t1\t\t3.5
no aprobado
2015970-0\tMETODOS NUMERICOS\t4\t0\t4\tB\t3\t1\t\t2.5
aprobado
2015970-8\tMETODOS NUMERICOS\t4\t0\t4\tB\t3\t1\t\t4.8
aprobado
2016375-0\tPROGRAMACIoN ORIENTADA A OBJETOS\t4\t0\t4\tC\t3\t1\t\t3.0
no aprobado
2016375-0\tPROGRAMACIoN ORIENTADA A OBJETOS\t4\t0\t4\tC\t3\t1\t\t2.5
aprobado
2016489-0\tCIRCUITOS ELECTRICOS I\t4\t0\t4\tL\t3\t1\t\t3.2
aprobado
2016495-0\tELECTRoNICA ANALOGA I\t6\t0\t6\tL\t4\t1\t\t3.2
aprobado
2016498-0\tELECTRoNICA DIGITAL I\t5\t0\t5\tC\t4\t1\t\t4.0
aprobado
2016500-0\tFISICA DE SEMICONDUCTORES\t4\t0\t4\tL\t3\t1\t\t3.3
aprobado
2016502-0\tINTRODUCCIoN A INGENIERIA ELECTRoNICA\t5\t0\t5\tL\t5\t1\t\t3.3
aprobado
2016509-0\tTALLER DE INGENIERIA ELECTRoNICA\t4\t0\t4\tL\t2\t1\t\t4.2
aprobado
2016699-4\tESTRUCTURAS DE DATOS\t4\t0\t4\tC\t3\t1\t\t3.6
aprobado
2024296-0\tSEGURIDAD ELECTRICA\t3\t0\t3\tL\t3\t1\t\t4.6
aprobado
2025970-3\tMODELOS Y SIMULACIoN\t4\t0\t4\tC\t3\t1\t\t3.3
aprobado
2025975-1\tINTRODUCCIoN A LA INGENIERIA DE SISTEMAS Y COMPUTACIoN\t4\t0\t4\tC\t3\t1\t\t4.5
aprobado
2016506-0\tSENALES Y SISTEMAS I\t4\t0\t4\tC\t3\t1\t\t3.8
aprobado
5-0\tRECONOCIMIENTO IDIOMA NIVEL I - II - III - IV\t0\t0\t0\tP\t12\t1\tF\tAP
  02\tperiodo academico | 2014-II\t\t
codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.
aprobado
2016353-4\tBASES DE DATOS\t4\t0\t4\tC\t3\t1\t\t4.2
aprobado
2016696-2\tALGORITMOS\t4\t0\t4\tB\t3\t1\t\t5.0
aprobado
2025963-1\tMATEMATICAS DISCRETAS I\t4\t0\t4\tB\t4\t1\t\t3.7
aprobado
2025982-2\tSISTEMAS DE INFORMACIoN\t4\t0\t4\tC\t3\t1\t\t3.7
  03\tperiodo academico | 2015-I\t\t
codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.
aprobado
2015174-2\tINTRODUCCIoN A LA TEORIA DE LA COMPUTACIoN\t4\t0\t4\tB\t4\t1\t\t3.6
aprobado
2016697-2\tARQUITECTURA DE COMPUTADORES\t4\t0\t4\tC\t3\t1\t\t4.2
aprobado
2016701-1\tINGENIERIA DE SOFTWARE I\t4\t0\t4\tC\t3\t1\t\t4.1
aprobado
2025971-3\tOPTIMIZACIoN\t4\t0\t4\tC\t3\t1\t\t4.5
  04\tperiodo academico | 2015-II\t\t
codigo-gr\tcurso\tHAP\tHAI\tTHS\ttip\tC\tN\tS\tcal.
aprobado
2016703-1\tPENSAMIENTO SISTEMICO\t4\t0\t4\tC\t3\t1\t\t4.3
aprobado
2016707-1\tSISTEMAS OPERATIVOS\t4\t0\t4\tC\t3\t1\t\t4.6
aprobado
2019764-1\tAPRENDIZAJE DE MAQUINA\t4\t0\t4\tL\t4\t1\t\t3.5
aprobado
2025967-2\tREDES DE COMPUTADORES\t4\t0\t4\tC\t3\t1\t\t4.0
aprobado
2025995-2\tINTRODUCCIoN A LOS SISTEMAS INTELIGENTES\t3\t0\t3\tC\t3\t1\t\t4.0
 \t\t
Promedio Academico\t[3.6]
Promedio Aritmetico Ponderado Acumulado - PAPA\t[3.6]
\t
80.0%
% de avance en los creditos exigidos del plan de estudios

\t\t\t\t\t\t\t\t\t\t
\t
\t\t\t\t\t\t\t\t\t\t
creditos\tplan de estudios\tnivel\ttotal estudiante\t
fundam.\tdiscipl.\tlibre e.\ttotal
exigidos\t51\t81\t33\t165\t16\t181\t
aprobados\t51\t49\t34\t134\t12\t146\t
aprobados plan\t51\t48\t33\t132\t--\t132\t
pendientes\t0\t33\t0\t33\t4\t37\t
inscritos\t57\t61\t34\t152\t0\t152\t
Creditos excedentes\tFundamentacion\t0\tDisciplinar-Profesional\t0\tTotal creditos excedentes\t0\t
Total de creditos cancelados en los periodos cursados\t9\t
resumen de creditos\t
Cupo adicional de creditos\t80\t
Cupo creditos\t79\t
cupo de creditos menos creditos pendientes\t42\t


version impresion

inicio | comentarios y sugerencias | preguntas frecuentes | descarga de archivos | mapa del sitio | noticias | terminos de uso
Sistema de Informacion Academica [Nivel Nacional]
Ciudad Universitaria, Cra 30 # 45-03 - Edificio 103 Polideportivo 2 Piso, Bogota - Colombia | www.registro.unal.edu.co | divregistro_bog@unal.edu.co
Actualizado: 1 de Febrero de 2016 | Todos los derechos reservados ©Universidad Nacional de Colombia 2016
"""

    def setup() {
    }

    def cleanup() {
    }

    def "testing periods size"() {
        when:
        def periods = controller.getPeriods(academicRecord)
        def periodsSize = periods.size()
        then:"size of periods"
        periodsSize == 4
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
        a << [0, 1, 2, 3]
        c << [3.525510204081632, 3.5945945945945947, 3.643548387096774, 3.6892857142857145]
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
        0 || 3.592391304347826
        1 || 3.6571428571428575
        2 || 3.701694915254238
        3 || 3.742537313432836
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

}

