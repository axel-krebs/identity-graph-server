#!/bin/bash

function create_user(){
	echo "Creating user $1, password: $2"
	useradd --home-dir /home/$1 -m --shell /bin/bash -U -p $2 $1
	#echo "$1:$2" | chpasswd
}

echo "Installing: $1"
fileName=$1
# we keep the version here (no strip!) since it's also in the tarball..'
dirName=${fileName%.tar.gz}
tar -xvf $fileName -C /opt
echo "KARAF_HOME=/opt/$dirName" >> /etc/environment
echo "JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64" >> /etc/environment
create_user "karaf" "karaf#123"
touch /home/karaf/.bashrc
chown karaf /home/karaf/.bashrc
chown karaf /opt/$dirName -R
echo "#!/bin/bash" > /home/karaf/.bashrc
echo "export PATH=\"\$PATH:\$KARAF_HOME/bin\"" >> /home/karaf/.bashrc

exit 0