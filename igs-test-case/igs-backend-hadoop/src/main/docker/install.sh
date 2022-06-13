#!/bin/bash

function create_user(){
	groupadd -r $1
	useradd --home-dir /home/$1 -m -s /bin/bash -g $1 -p $2 $1
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

# set env vars for user hadoop
cat <<EOF > /home/$userName/.bashrc
#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export HADOOP_HOME=/opt/$dirName
export PATH=$PATH:\$HADOOP_HOME/bin
export HADOOP_CONF_DIR=\$HADOOP_HOME/etc/hadoop
EOF

# prepare F/S
mkdir /srv/dfs
mkdir /srv/dfs/namespace_logs
mkdir /srv/dfs/data
chown $userName:$userName /srv/dfs -R

# add config files
source /home/$userName/.bashrc
mv core-site.xml $HADOOP_CONF_DIR && chown $userName:$userName $HADOOP_CONF_DIR/core-site.xml
mv hdfs-site.xml $HADOOP_CONF_DIR && chown $userName:$userName $HADOOP_CONF_DIR/hdfs-site.xml
mv mapred-site.xml $HADOOP_CONF_DIR && chown $userName:$userName $HADOOP_CONF_DIR/mapred-site.xml
mv yarn-site.xml $HADOOP_CONF_DIR && chown $userName:$userName $HADOOP_CONF_DIR/yarn-site.xml

# Format F/S; somehow the sourcing does not apply, therfore specify core-site.xml directly
su - $userName -c "hdfs namenode -conf \$HADOOP_CONF_DIR/core-site.xml -format"

exit 0
