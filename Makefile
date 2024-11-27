build:
	mvn complile

package:
	mvn package

docker-build:
	docker build -t customer-management:1.0 .