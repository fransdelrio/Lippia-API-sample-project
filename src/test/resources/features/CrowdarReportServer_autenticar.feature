#CRS: siglas para Crowdar Report Server.
Feature: Autenticar en Report Server de Crowdar
  COMO  Usuario de Report Server
  DESEO Verificar mis credenciales
  PARA  Obtener un token que me permita usar la API

  @CrowdarReportServer
  Scenario Outline: Obtener token
    When  realizo una peticion '<operation>' a '<entity>' al endpoint de autenticacion '<request>'
    Then  Obtengo status code '<statusCode>'
    And   Obtengo un token

    Examples:
      | request                     | statusCode | operation | entity       |
      | request/rq_crs_authenticate | 200        | POST      | AUTHENTICATE |

