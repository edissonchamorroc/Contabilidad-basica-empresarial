# contabilidad_empresarial
Aplicativo web administrador el cual puede gestionar los ingresos y egresos de una empresa. 
El permite visualizar los totales de la empresa para que el gerente pueda tomar decisiones sobre la situación financiera.
La aplicación permite la creación de nuevos usuarios los cuales tienen la posibilida de efectuar nuevos movimientos de dinero,
sin embargo, dichos usuarios no deben ser capaces de modificar información sensible de la empresa, ni tampoco crear nuevos usuarios,
con el fin de evitar riesgos de corrupción. Adicionalmente, debido a que las transacciones contables son supremamente delicadas,
el sistema permite llevar una trazabilidad de quién registró cada transacción, por lo cual el sistema debe contar con un sistema de autenticación.
Este proyecto es realizado con frameworks spring boot y thymeleaf.

                                           Página de Inicio
![image](https://user-images.githubusercontent.com/71468355/193381248-6adb7c5d-97e5-4696-9329-a87aa394627f.png)

Para poder ingresar a la aplicación se debe pasar el proceso de login. 
Por medio de este, se especifica al programa si el empleado logueado es administrador
o es tiene rol usuario.

- ADMINISTRADOR:   user:admin@gmail.com    password:1234
-USUARIO:          user:usuario@gmail.com  password:1234

Si el empleado es administrador, posee facultades para modificar o eliminar, de lo contrario
solo podrá registrar datos.



