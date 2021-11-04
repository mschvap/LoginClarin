Feature: Realizar login a Clarin y obtener error
  Como usuario no registrado
  Quiero ingresar a la pagina www.clarin.com
  Para realizar el logueo y obtener error


  Scenario Outline: Realizar login a Clarin y obtener error
    Given usuario registrado
    When ingresa usuario y contraseña
      | <usuario>        |<contrasena>|
    Then se ve mensaje de error de mail

    Examples:
      |usuario                 |contrasena|
      |usuariopase12@gmail.com |Pase.1234 |
      |usuariopase11@gmail.com |Pase.1234 |
