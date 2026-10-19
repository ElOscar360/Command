# Cafeteria - Patron Command

El mesero crea pedidos y los envia a la cocina, que los ejecuta paso a paso. Si un pedido se cancela o modifica en medio de la preparacion, se deshacen los pasos hechos (`undo`) y los equipos vuelven a su estado inicial.

Paquetes: `command`, `receptores`, `pedidos`, `cocina`, `personal`.

```
javac -d out $(find src -name "*.java")
java -cp out cafeteria.Main
```
