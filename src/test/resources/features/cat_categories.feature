Feature: Cat API
  COMO  usuario de CatAPI
  DESEO obtener la lista de categorias
  PARA  visualizar las mismas

  @Example @Success @CatAPI
  Scenario Outline: Obtengo la lista de categorias
    When  Realizo una peticion '<operation>' a '<entity>' al endpoint de categorias - '<request>'
    Then  Obtengo el status code '<statusCode>'
    And   Los datos son correctos
    @SuccessCatAPI
    Examples:
      | request                   | statusCode | operation | entity     |
      | request/rq_cat_categories | 200        | GET       | CATEGORIES |

  @Example @Unsuccess @CatApi
  Scenario Outline: Análisis de imágenes
    When  Realizo una peticion '<operation>' a '<entity>' al endpoint de analisis - '<request>'
    Then  Obtengo el status code '<statusCode>'

    Examples:
      | request                   | statusCode | operation | entity     |
      | request/rq_img_analysis | 200        | GET       | CATEGORIES |
