#!/bin/bash

function create_user(){
	echo "Creating user $1, password: $2"
	useradd --home-dir /home/$1 -m --shell /bin/bash -U -p $2 $1
	#echo "$1:$2" | chpasswd
}

echo "Installing: $1"

fileName=$1
dirName=${fileName%.tar.gz}
userName=$2
passWord=$3
create_user $userName $passWord
tar -zxf $fileName -C /opt
chown $userName:$userName /opt/$dirName -R
rm $fileName

# set env vars for user karaf
cat <<EOF > /home/$userName/.bashrc
#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export KARAF_HOME=/opt/$dirName
export PATH=$PATH:\$KARAF_HOME/bin
EOF

exit 0
