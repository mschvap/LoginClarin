Feature: Realizar registro a Clarin
  Como usuario no registrado
  Quiero ingresar a la pagina www.clarin.com
  Para realizar el registro de cuenta

  @si
  Scenario Outline: Realizar login a Clarin
    Given usuario no registrado
    When ingresa usuario y contraseña nueva
      | <usuario>        |<contrasena>|
    Then se activa cuenta por mail

    Examples:
      |usuario                  |contrasena|
      |usuariopase9@yopmail.com |Pase.1234 |