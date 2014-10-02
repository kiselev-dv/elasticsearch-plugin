echo "Packaging and installing the plugin into ElasticSearch"
mvn clean package
/usr/local/Cellar/elasticsearch/1.2.1/bin/plugin -url file:./target/release/elasticsearch-PeliasPlugin-1.3.4.zip -install pelias-plugin
