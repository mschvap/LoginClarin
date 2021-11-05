Feature: Realizar login a Clarin
  Como usuario no registrado
  Quiero ingresar a la pagina www.clarin.com
  Para realizar el logueo

  @no
  Scenario Outline: Realizar login a Clarin
    Given usuario registrado
    When ingresa usuario y contraseña
      | <usuario>        |<contrasena>|
    Then se ve mensaje de bienvenida

    Examples:
      |usuario                |contrasena|
      |usuariopase1@gmail.com |Pase.1234 |
