# Developer roadmap

Ejemplo de roadmap con neo4j

## levantar neo4j
```bash

cd docker/

export NEO4J_USER="neo4j"
export NEO4J_PASS="1234"

docker-compose up

# or
cd docker/
sh create-neo4j-container.sh

```
## ingresar a neo4j

Una vez levantado el contenedor neo5j ir a la url  http://localhost:7474/ e ingresar las credenciales seteadas en el archivo
docker/create-neo4j-container.sh

## ejecutar la aplicacion

ejecutar el script run-app.sh

```bash
sh run-app.sh
```

se creara un grafo basico de un path para learning de un developer

### Backlog

- [x] modelo basico de entidades
- [x] creacion docker container
- [ ] crear endpoints REST
- [ ] crear queries de ejemplos 
