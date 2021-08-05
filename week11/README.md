# Docker file

Build an image  `docker build -t temptingmorsels .`</br>
Download MySql image `docker pull mysql:5.7 `</br>
Set data `docker run --name dessert-shop -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=TemptingMorselsDess -e MYSQL_ROOT_PASSWORD=password -e MYSQL_PASSWORD=password -d mysql:5.7`</br>
Verify the MySql start up logs `docker container logs dessert-shop`</br>
Run the project `docker run -d -p 9090:9090 --name temptingmorsels --link dessert-shop:mysql temptingmorsels`</br>
Verify the app start up logs `docker container logs temptingmorsels `</br>


