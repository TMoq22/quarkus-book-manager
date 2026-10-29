#!/usr/bin/bash

curl -X POST http://localhost:8080/books -H "Content-Type: application/json" -d '{"title": "Les Misérables", "author": "Victor Hugo", "pages": 1800}'  
curl -X POST http://localhost:8080/books -H "Content-Type: application/json" -d '{"title": "Le Petit Prince", "author": "Antoine de Saint-Exupéry", "pages": 96}'

echo "insersion réalisé"

curl http://localhost:8080/books
