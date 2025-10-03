CQL="CREATE KEYSPACE IF NOT EXISTS main WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

echo "Keyspace created successfully"

exec /usr/local/bin/docker-entrypoint.sh "$@"