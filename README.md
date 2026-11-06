# Odio el Chocolate (Forge 1.20.1)

Mod con el mob **Chocolate**. Requiere Minecraft 1.20.1 + Forge 47.x y Java 17 para compilar.

## Compilar con GitHub (sin instalar nada)

1. Crea un repositorio nuevo en github.com y sube todo el contenido de esta carpeta.
2. Verifica que exista el archivo `.github/workflows/build.yml`. Si no se subio (es una carpeta oculta),
   crealo con "Add file > Create new file", escribe esa ruta y pega el contenido del archivo.
3. Entra a la pestana **Actions**, abre la ejecucion "Compilar mod" y espera a que termine (unos minutos).
4. Abajo, en **Artifacts**, descarga `odioelchocolate-jar`. Dentro esta `odioelchocolate-1.0.0.jar`.
5. Copialo a la carpeta `mods` de tu modpack (Forge 1.20.1).

Si la compilacion falla, copia el error de la ejecucion y pasaselo a Claude.

## Compilar en tu PC

Con JDK 17 y Gradle 8.1.1 instalados: `gradle build`. El jar queda en `build/libs/`.

## Comandos

- `/chocosound chocochase1 | chocochase2 | chocospawn | stop [jugadores]`
- Tambien sirve `/playsound odioelchocolate:chocospawn master @s`
- Invocar el mob: huevo de aparicion (pestana de huevos) o `/summon odioelchocolate:chocolate`

## Donde ajustar el comportamiento

Las constantes (velocidades, danos, tiempos) estan al inicio de
`src/main/java/com/odioelchocolate/entity/ChocolateEntity.java`.
La imagen del mob es `src/main/resources/assets/odioelchocolate/textures/entity/chocolate.png`
(puedes reemplazarla por otra con el mismo nombre; si cambia la proporcion, ajusta `ASPECT` en `ChocolateRenderer.java`).
