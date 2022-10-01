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
o es tiene rol usuario. Ingresa cualquiera de estos perfiles en el login para
acceder a la aplicación.

- ADMINISTRADOR:   user:admin@gmail.com    password:1234
-USUARIO:          user:usuario@gmail.com  password:1234

![image](https://user-images.githubusercontent.com/71468355/193383863-ab869538-eb0b-4346-8a59-b473bf70efd4.png)


Al pasar el login se observa los tres sistemas de gestión con los que 
cuenta la apliación.

![image](https://user-images.githubusercontent.com/71468355/193383884-643b3f11-0612-4e53-95bd-d624214487ca.png)

Cada sistema de gestión cuenta con dos opciones, registro y el listado que hay en base de datos 
respectivo a lo que se está gestionando.

![image](https://user-images.githubusercontent.com/71468355/193383925-a63bd270-d750-4890-98f6-b31fa960c941.png)

Cuando se desea registrar, se debe llenar el formulario con los datos solicitados.

![image](https://user-images.githubusercontent.com/71468355/193383990-9a8e744d-da74-4456-b3c3-fc522eefaba6.png)


Cuando se elige la opcion listado, se podrá ver lo que hay registrado en la base de datos
y si el empleado es administrador, posee facultades para modificar o eliminar, de lo contrario
solo podrá registrar datos.

![image](https://user-images.githubusercontent.com/71468355/193384004-3c2d4a3d-71f6-41c0-8eb8-fc3acb4d245d.png)


                                  Arquitectura de la Solucion
![image](https://user-images.githubusercontent.com/71468355/193384049-a42bb85a-36f0-4247-bc38-a71b2b926c8e.png)

                                  Diagrama Entidad-Relación
![image](https://user-images.githubusercontent.com/71468355/193384153-cd02b60b-bae1-479f-950d-502cbfd762eb.png)
                           




