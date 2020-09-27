Feature: Cat API
  COMO  Usuario de CatAPI
  DESEO obtener la lista de categorias
  PARA  visualizar las mismas

  @Example @Success @CatAPI
  Scenario Outline: Obtengo la lista de categorias
    When  realizo una peticion '<operation>' a '<entity>' al endpoint de categorias '<request>'
    Then  Obtengo status code '<statusCode>'
    And   Los datos son correctos
    @SuccessCatAPI
    Examples:
      | request                   | statusCode | operation | entity     |
      | request/rq_cat_categories | 200        | GET       | CATEGORIES |

