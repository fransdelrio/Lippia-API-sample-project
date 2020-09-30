#CRS: siglas para Crowdar Report Server.
Feature: Consultar proyectos en Report Server de Crowdar
  COMO  Usuario autenticado de Report Server
  DESEO Obtener la lista de proyectos
  PARA  Poder consultar sus datos

  @CrowdarReportServer @projects
  Scenario Outline: Obtener lista de proyectos
    Given realizo una peticion '<operation1>' a '<entity1>' al endpoint '<request1>'
    And Obtengo status code '<statusCode1>'
    And Obtengo un token
    When  realizo una peticion '<operation2>' a '<entity2>' al endpoint '<request2>'
    Then  Obtengo status code '<statusCode2>'

    Examples:
      | request1                    | statusCode1 | operation1 | entity1      | request2                 | statusCode2 | operation2 | entity2  |
      | request/rq_crs_authenticate | 200         | POST       | AUTHENTICATE | request/rq_crs_projectsq | 200         | GET        | PROJECTS |

