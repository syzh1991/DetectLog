# DetectLog

(1) Start Zookeper server using command - bin/zookeeper-server-start.sh config/zookeeper.properties

(2) Start Kafka server using command - bin/kafka-server-start.sh config/server.properties

(3) Create a topic using command - bin/kafka-topics.sh --create --zookeeper Naruto.ccntgrid.zju.edu:2181 --replication-factor 3 --partitions 1 --topic testdir

(4) Create a dir using command - mkdir -p /home/songyang/kafkadata/test

(5) Start producer using command - java -jar jarname

(6) Start consumer using command - java -jar jarname

(7) Put file to dir /home/songyang/kafkadata/test
