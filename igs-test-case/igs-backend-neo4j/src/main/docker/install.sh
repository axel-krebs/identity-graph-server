#!/bin/bash

function create_user(){
	echo "Creating user $1, password: $2"
	useradd --home-dir /home/$1 -m --shell /bin/bash -U -p $2 $1
	#echo "$1:$2" | chpasswd
}

echo "Installing: $1"
create_user "neo4j" "neo4j"

exit 0