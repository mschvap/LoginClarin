Feature: Realizar registro a Clarin
  Como usuario no registrado
  Quiero ingresar a la pagina https://prepro.int.clarin.com/
  Para realizar el registro de cuenta

  @si
  Scenario Outline: Realizar login a Clarin
    Given usuario no registrado
    When ingresa usuario y contraseña nueva
      | <usuario>        |<contrasena>|
    Then se activa cuenta por mail

    Examples:
      |usuario                  |contrasena|
      |usuariopase11@yopmail.com |Pase.1234 |