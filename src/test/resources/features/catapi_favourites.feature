Feature: CatAPI Favourites
  Como  Usuario de CatAPI
  DESEO Obtener mi lista de favoritos
  PARA  Visualizar lo que he agregado a favoritos

  @Example @Success @CatAPI
  Scenario Outline: Obtener lista de favoritos
    When  Realizo una peticion '<operation>' a '<entity>' al endpoint de favoritos - '<request>'
    Then  Obtengo el status code '<statusCode>'
    And   Los datos son correctos
    @SuccessCatAPI
    Examples:
      | request                   | statusCode | operation | entity     |
      | request/------- | 200        | GET       | FAVOURITES |