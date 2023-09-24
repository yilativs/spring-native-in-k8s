# A Spring Native Sample App for K8S Deployment Example

## Reference Documentation


### Build native image

mvn -Pnative spring-boot:build-image 


### deploy to k8s cluster

kubectl apply -f  k8s/manifest.yml


### swagger url

swagger url for local debug http://127.0.0.1:8080/swagger-ui/index.html


### TODO

* add secrets and configmap
* add second service
* add cache on Redis
* add second service
* add stateful deployment for postgres with a hotstandby
* add OpenID Connect support + KeyClock
