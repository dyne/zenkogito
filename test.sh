#!/bin/bash

echo "Example 1"
curl -X 'POST' \
  'http://localhost:8080/pubgen' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{}'

echo
echo "Example 2"
curl -X 'POST' \
  'http://localhost:8080/verify' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "message": "{\r\n\t\"myStringArray\": [\r\n\t\t\"Hello World! This is my string array, element [0]\",\r\n\t\t\"Hello World! This is my string array, element [1]\",\r\n\t\t\"Hello World! This is my string array, element [2]\"\r\n\t],\r\n\t\"myStringArray.eddsa-signature\": \"4P3ZB2rAoeMah7WXwenTuJgzENJxF9HGis1UU8392ydz6PYJjjJ3ZM8BtiGd69zr3NEAacaqwzpasGkkUEJoQYDP\"\r\n}"
}'