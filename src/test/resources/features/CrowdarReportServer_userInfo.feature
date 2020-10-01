#CRS: siglas para Crowdar Report Server.
Feature: Consultar info de usuario en Report Server de Crowdar
  COMO  Usuario autenticado de Report Server
  DESEO Obtener mi información de usuario
  PARA  Poder visualizarla

  @CrowdarReportServer @User
  Scenario Outline: Obtener info de usuario
    Given realizo una peticion '<operation1>' a '<entity1>' al endpoint '<request1>'
    And Obtengo status code '<statusCode1>'
    And Obtengo un token
    When  realizo una peticion '<operation2>' a '<entity2>' al endpoint '<request2>'
    Then  Obtengo status code '<statusCode2>'

    Examples:
  | request1                    | statusCode1 | operation1 | entity1      | request2              | statusCode2 | operation2 | entity2 |
  | request/rq_crs_authenticate | 200         | POST       | AUTHENTICATE | request/rq_crs_userme | 200         | GET        | USERME  |

