**Nombre del proyecto:**
Connections

**Descripción:**
Connections es un sistema de seguimiento de relaciones en una red social que permite a los usuarios generar un grafo a partir de estas relaciones. El proyecto tiene como objetivo cargar información de usuarios y sus conexiones a partir de archivos de texto, permitiendo a los usuarios modificar el grafo, actualizar los datos en un repositorio y visualizar representaciones visuales del grafo. Además, se proporciona una función para identificar componentes fuertemente conectados utilizando el algoritmo de Kosaraju con búsqueda en profundidad (DFS).

**Versión:**
29/10/2023

**Autores:**
- Jose Ignacio Francisco (Usuario: joseigfranc)
- Diego Hernandez (Usuario: DAHDOR)
- Tomas Araujo (Usuario: tomasaraujo21)

**Instrucciones para arrancar el proyecto:**
Para ejecutar el proyecto, sigue estos pasos:
1. Descarga o clona el repositorio desde [URL del repositorio].
2. Asegúrate de tener Java instalado en tu sistema.
3. Compila el proyecto si es necesario.
4. Ejecuta la aplicación desde la línea de comandos o mediante tu IDE favorito.
5. Ejecutar el método main
6. 

**Instrucciones para los usuarios:**
El proyecto "Connections" te permite realizar las siguientes acciones:
1. Cargar archivo: Utiliza la opción "Cargar archivo" para seleccionar un archivo de texto plano (archivo .txt) que contenga información sobre usuarios y sus conexiones. Asegúrate de que el archivo cumple con el formato especificado. (formato especificado en el anexo)
2. Modificar grafo: Puedes seleccionar usuarios para eliminarlos del grafo o agregar nuevos usuarios, indicando sus relaciones con otros usuarios.
3. Actualizar repositorio: Los cambios realizados en el grafo se pueden guardar en el archivo de texto original para que los cambios se mantengan al cargarlo nuevamente.
4. Mostrar grafo: La aplicación mostrará una representación visual del grafo, incluyendo las relaciones entre los usuarios. 
5. Identificación de componentes fuertemente conectados: Utiliza la función para encontrar componentes fuertemente conectados en el grafo utilizando el algoritmo de Kosaraju con búsqueda en profundidad (DFS). Los componentes se destacarán con colores distintos.


**Ejemplo del formato de archivo de datos:**

usuarios

@pepe
@mazinger
@juanc
@xoxojaime
@tuqui33
@sancho23
@terciopelo
@caribedoble
@africa
@totalfree
@radiogaga
@cipriano
@newageforever

relaciones

@pepe, @mazinger
@mazinger, @juanc
@mazinger, @tuqui33
@tuqui33, @xoxojaime
@xoxojaime, @pepe
@juanc, @sancho23
@sancho23, @mazinger
@sancho23, @terciopelo
@terciopelo, @juanc
@terciopelo, @newageforever
@terciopelo, @caribedoble
@caribedoble, @africa
@africa, @cipriano
@cipriano, @totalfree
@cipriano, @radiogaga
@totalfree, @africa
@totalfree, @radiogaga
@radiogaga, @caribedoble


