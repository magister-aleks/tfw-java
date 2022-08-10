#!/bin/sh

docker-compose down
docker-compose up -d

echo "Step 5 - Check Selenoid status"
curl http://localhost:4444/status -v