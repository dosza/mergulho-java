up:
	docker-compose up
down:
	docker-compose down
	cd ./rh-api; docker-compose down

stop:
	docker-compose stop

build:
	docker-compose up --build

destroy:
	docker-compose down -v
	cd ./rh-api; docker-compose down -v

clean:
	docker-compose down --rmi local -v
	cd ./rh-api; docker-compose down --rmi local -v

database:
	cd ./rh-api; docker-compose up 
all: up


